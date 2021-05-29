package be.odisee.producten.controllers;

import be.odisee.producten.DAO.BestellingLijnRepository;
import be.odisee.producten.DAO.BestellingRepository;
import be.odisee.producten.dataKlassen.BestellingModel;
import be.odisee.producten.dataKlassen.EntryBestellingLijn;
import be.odisee.producten.domain.Bestelling;
import be.odisee.producten.domain.BestellingLijn;
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
public class BestellingController {
    @Autowired
    private BestellingRepository bestellingRepository;

    @Autowired
    private BestellingLijnRepository bestellingLijnRepository;

    /**
     * Returned een lijst van alle bestellingen en hun lijnen
     */
    @GetMapping("/list")
    public Object getBestellingen(){
        List<Bestelling> myList = bestellingRepository.findAll();
        List<BestellingModel> myListModel = new ArrayList<>();

        for (Bestelling bes : myList)
        {
            myListModel.add( new BestellingModel(bes.getId(), bes.getTotale_prijs(), bes.getKlant_nummer(), bes.getBestelling_status(), bes.getBesteltijd(), bestellingLijnRepository.findAllByBestelling_Id(bes.getId())));
        }

        return myListModel;
    }

    /**
     * Returned een bestelling a.d.h.v het ID
     */
    @RequestMapping(value={"/bestellingdetails/{id}"},method= RequestMethod.GET)
    public @ResponseBody
    BestellingLijn getBestelling(@PathVariable("id") Integer id) {
        //code
        return null;
    }
    /**
     * Aanmaken van een bestelling
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/createbestelling"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createBestelling(@Valid @RequestBody EntryBestellingLijn entry, Errors errors) {
        //code
        return null;
    }
    /**
     * updaten van een bestelling
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/updatebestelling"},method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String putBestelling(@Valid @RequestBody EntryBestellingLijn entry, Errors errors){
        //code
        return null;
    }

    /**
     * Deleten van een bestelling a.d.h.v ID
     */
    @RequestMapping(value={"/deletebestelling/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBestelling(@PathVariable("id") Integer id){
        //code
    }
}
