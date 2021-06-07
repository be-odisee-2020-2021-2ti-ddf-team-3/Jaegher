package be.odisee.producten.controllers;

import be.odisee.producten.DAO.BestellingLijnRepository;
import be.odisee.producten.DAO.BestellingRepository;
import be.odisee.producten.dataKlassen.BestellingLijnModel;
import be.odisee.producten.dataKlassen.BestellingModel;
import be.odisee.producten.dataKlassen.EntryBestelling;
import be.odisee.producten.dataKlassen.EntryBestellingLijn;
import be.odisee.producten.domain.Bestelling;
import be.odisee.producten.domain.BestellingLijn;
import be.odisee.producten.service.BestellingLijnService;
import be.odisee.producten.service.BestellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/bestellingen", produces = "application/json")
@CrossOrigin(origins={"*"},
        maxAge = 3600)
public class BestellingController {

    @Autowired
    private BestellingService bestellingService;
    @Autowired
    private BestellingRepository bestellingRepository;

    @Autowired
    private BestellingLijnRepository bestellingLijnRepository;

    /**
     * Returned een lijst van alle bestellingen en hun lijnen
     */
    @GetMapping("/list")
    public Object getBestellingen(){
        return bestellingService.getBestellingen();
    }

    /**
     * Returned een bestelling a.d.h.v het ID
     */
    @RequestMapping(value={"/bestellingdetails/{id}"},method= RequestMethod.GET)
    public @ResponseBody
    BestellingModel getBestelling(@PathVariable("id") Integer id) {
        return bestellingService.getBestelling(id);
    }
    /**
     * Aanmaken van een bestelling
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/createbestelling"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long createBestelling(@Valid @RequestBody Bestelling entry, Errors errors) {
        StringBuilder message=new StringBuilder();
        long id = 0;
        try {
            if (errors.hasErrors() ) {
                message = new StringBuilder("Er is iets fout gelopen: ");
                for (ObjectError objectError: errors.getAllErrors()) {
                    message.append(objectError.getDefaultMessage()).append(",");
                }
                throw new IllegalArgumentException();
            }
            Bestelling product = bestellingService.addBestelling(entry);
            message = new StringBuilder("De bestelling " + product.getId() + " is succesvol aangemaakt");
            id = product.getId();
        } catch (IllegalArgumentException e) {
        }
        return id;
    }
    /**
     * updaten van een bestelling
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/updatebestelling"},method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String putBestelling(@Valid @RequestBody EntryBestelling entry, Errors errors){
        StringBuilder message=new StringBuilder();

        try {
            if (errors.hasErrors() ) {
                message = new StringBuilder("Er is iets fout gelopen: ");
                for (ObjectError objectError: errors.getAllErrors()) {
                    message.append(objectError.getDefaultMessage()).append(",");
                }
                throw new IllegalArgumentException();
            }
            Bestelling product = bestellingService.updateBestelling(entry, entry.getId());
            message = new StringBuilder("De bestelling " + product.getId() + " is succesvol aangepast");

        } catch (IllegalArgumentException e) {
        }
        return message.toString();
    }

    /**
     * Deleten van een bestelling a.d.h.v ID
     */
    @RequestMapping(value={"/deletebestelling/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBestelling(@PathVariable("id") Integer id){
        bestellingService.deleteBestelling(id);
    }
}
