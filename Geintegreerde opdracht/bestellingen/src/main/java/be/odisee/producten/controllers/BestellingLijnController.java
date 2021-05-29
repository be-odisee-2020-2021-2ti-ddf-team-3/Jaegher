package be.odisee.producten.controllers;

import be.odisee.producten.DAO.BestellingLijnRepository;
import be.odisee.producten.dataKlassen.EntryBestellingLijn;
import be.odisee.producten.domain.BestellingLijn;
import be.odisee.producten.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path="/bestellinglijn", produces = "application/json")
public class BestellingLijnController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BestellingLijnRepository bestellingLijnRepository;


    /**
     * Returned een lijst van alle bestellinglijnen
     */
    @GetMapping("/list")
    public Object getObjectives(){
        return productService.getAllLijnen();
    }
    /**
     * Returned een lijst van alle lijnen afhankelijk van hun bestelling
     */
    @RequestMapping(value={"/listbestelling/{id}"},method=RequestMethod.GET)
    public Object getBestellingLijnenBestelling(@PathVariable("id") Integer id) {
        return bestellingLijnRepository.findAllByBestelling_Id(id);
    }
    /**
     * Returned een lijn a.d.h.v het ID
     */
    @RequestMapping(value={"/details/{id}"},method=RequestMethod.GET)
    public @ResponseBody
    BestellingLijn getLijn(@PathVariable("id") Integer id) {
        return bestellingLijnRepository.findById(id);
    }
    /**
     * Aanmaken van een lijn
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/create"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createLijn(@Valid @RequestBody EntryBestellingLijn entry, Errors errors) {
        StringBuilder message=new StringBuilder();

        try {
            if (errors.hasErrors() ) {
                message = new StringBuilder("Er is iets fout gelopen: ");
                for (ObjectError objectError: errors.getAllErrors()) {
                    message.append(objectError.getDefaultMessage()).append(",");
                }
                throw new IllegalArgumentException();
            }
            BestellingLijn bestellingLijn = productService.addBestellingLijn(entry);
            message = new StringBuilder("Het product " + bestellingLijn.getProduct_naam() + " is succesvol toegevoegd");

        } catch (IllegalArgumentException e) {
        }
        return message.toString();
    }
    /**
     * updaten van een lijn
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/update"},method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String putLijn(@Valid @RequestBody EntryBestellingLijn entry, Errors errors){
        StringBuilder message=new StringBuilder();

        try {
            if (errors.hasErrors() ) {
                message = new StringBuilder("Er is iets fout gelopen: ");
                for (ObjectError objectError: errors.getAllErrors()) {
                    message.append(objectError.getDefaultMessage()).append(",");
                }
                throw new IllegalArgumentException();
            }
            BestellingLijn bestellingLijn = productService.updateLijn(entry, entry.getId());
            message = new StringBuilder("Het product " + bestellingLijn.getProduct_naam() + " is succesvol aangepast");

        } catch (IllegalArgumentException e) {
        }
        return message.toString();
    }

    /**
     * Deleten van een Lijn a.d.h.v ID
     */
    @RequestMapping(value={"/delete/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLijn(@PathVariable("id") Integer id){
        productService.deleteLijn(id);
    }



}
