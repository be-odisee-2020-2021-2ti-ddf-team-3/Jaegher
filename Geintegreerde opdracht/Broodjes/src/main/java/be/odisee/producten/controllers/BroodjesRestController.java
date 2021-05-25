package be.odisee.producten.controllers;

import be.odisee.producten.DAO.BroodjeRepository;
import be.odisee.producten.dataKlassen.EntryBroodje;
import be.odisee.producten.domain.Broodje;
import be.odisee.producten.service.BroodjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path="/broodjes", produces = "application/json")
public class BroodjesRestController {
    @Autowired
    private BroodjeService broodjeService;
    @Autowired
    private BroodjeRepository broodjeRepository;


    /**
     * Returned een lijst van alle producten
     */
    @GetMapping("/list")
    public Object getObjectives(){
        return broodjeService.getAllBroodjes();
    }
    /**
     * Returned een lijst van alle producten afhankelijk van hun categorie
     */
    @RequestMapping(value={"/listcategory/{id}"},method=RequestMethod.GET)
    public Object getBroodjes2(@PathVariable("id") Integer id) {
        return broodjeRepository.findAllByCategory_Id(id);
    }
    /**
     * Returned een product a.d.h.v het ID
     */
    @RequestMapping(value={"/productdetails/{id}"},method=RequestMethod.GET)
    public @ResponseBody
    Broodje getBroodje(@PathVariable("id") Integer id) {
        return broodjeRepository.findById(id);
    }
    /**
     * Aanmaken van een product
     * returned een gedetaileerde foutbootschap of bevestigings message
     */
    @RequestMapping(value={"/createproduct"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createBroodje(@Valid @RequestBody EntryBroodje entry, Errors errors) {
        StringBuilder message=new StringBuilder();

        try {
            if (errors.hasErrors() ) {
                message = new StringBuilder("Er is iets fout gelopen: ");
                for (ObjectError objectError: errors.getAllErrors()) {
                    message.append(objectError.getDefaultMessage()).append(",");
                }
                throw new IllegalArgumentException();
            }
            Broodje broodje = broodjeService.addBroodje(entry);
            message = new StringBuilder("Het product " + broodje.getNaam() + " is succesvol aangemaakt");

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
    public String putBroodje(@Valid @RequestBody EntryBroodje entry, Errors errors){
        StringBuilder message=new StringBuilder();

        try {
            if (errors.hasErrors() ) {
                message = new StringBuilder("Er is iets fout gelopen: ");
                for (ObjectError objectError: errors.getAllErrors()) {
                    message.append(objectError.getDefaultMessage()).append(",");
                }
                throw new IllegalArgumentException();
            }
            Broodje broodje = broodjeService.updateBroodje(entry, entry.getId());
            message = new StringBuilder("Het product " + broodje.getNaam() + " is succesvol aangepast");

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
        broodjeService.deleteBroodje(id);
    }




    @RequestMapping(value={"/createtestproduct"},method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    void createTestKlant(){
        broodjeService.addTest();
    }

}
