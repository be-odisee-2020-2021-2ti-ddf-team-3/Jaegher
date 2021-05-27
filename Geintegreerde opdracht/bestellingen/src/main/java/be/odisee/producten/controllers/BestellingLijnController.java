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
@RequestMapping(path="/producten", produces = "application/json")
public class BestellingLijnController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BestellingLijnRepository bestellingLijnRepository;


    /**
     * Returned een lijst van alle producten
     */
    @GetMapping("/list")
    public Object getObjectives(){
        return productService.getAllBroodjes();
    }
    /**
     * Returned een lijst van alle producten afhankelijk van hun categorie
     */
    @RequestMapping(value={"/listcategory/{id}"},method=RequestMethod.GET)
    public Object getBroodjes2(@PathVariable("id") Integer id) {
        return bestellingLijnRepository.findAllByBestelling_Id(id);
    }
    /**
     * Returned een product a.d.h.v het ID
     */
    @RequestMapping(value={"/productdetails/{id}"},method=RequestMethod.GET)
    public @ResponseBody
    BestellingLijn getBroodje(@PathVariable("id") Integer id) {
        return bestellingLijnRepository.findById(id);
    }
    /**
     * Aanmaken van een product
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/createproduct"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createBroodje(@Valid @RequestBody EntryBestellingLijn entry, Errors errors) {
        StringBuilder message=new StringBuilder();

        try {
            if (errors.hasErrors() ) {
                message = new StringBuilder("Er is iets fout gelopen: ");
                for (ObjectError objectError: errors.getAllErrors()) {
                    message.append(objectError.getDefaultMessage()).append(",");
                }
                throw new IllegalArgumentException();
            }
            BestellingLijn bestellingLijn = productService.addBroodje(entry);
            message = new StringBuilder("Het product " + bestellingLijn.getNaam() + " is succesvol aangemaakt");

        } catch (IllegalArgumentException e) {
        }
        return message.toString();
    }
    /**
     * updaten van een product
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/updateproduct"},method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String putBroodje(@Valid @RequestBody EntryBestellingLijn entry, Errors errors){
        StringBuilder message=new StringBuilder();

        try {
            if (errors.hasErrors() ) {
                message = new StringBuilder("Er is iets fout gelopen: ");
                for (ObjectError objectError: errors.getAllErrors()) {
                    message.append(objectError.getDefaultMessage()).append(",");
                }
                throw new IllegalArgumentException();
            }
            BestellingLijn bestellingLijn = productService.updateBroodje(entry, entry.getId());
            message = new StringBuilder("Het product " + bestellingLijn.getNaam() + " is succesvol aangepast");

        } catch (IllegalArgumentException e) {
        }
        return message.toString();
    }

    /**
     * Deleten van een product a.d.h.v ID
     */
    @RequestMapping(value={"/deleteproduct/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBroodje(@PathVariable("id") Integer id){
        productService.deleteBroodje(id);
    }




    @RequestMapping(value={"/createtestproduct"},method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    void createTestKlant(){
        productService.addTest();
    }

}
