package be.odisee.broodjes.controllers;

import be.odisee.broodjes.DAO.BroodjeRepository;
import be.odisee.broodjes.dataKlassen.EntryBroodje;
import be.odisee.broodjes.domain.Broodje;
import be.odisee.broodjes.service.BroodjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping(path="/broodjesrest", produces = "application/json")
public class BroodjesRestController {
    @Autowired
    private BroodjeService broodjeService;
    @Autowired
    private BroodjeRepository broodjeRepository;


    @GetMapping("/broodjes")
    public Object getObjectives(){
        return broodjeService.getAllBroodjes();
    }

    @RequestMapping(value={"/broodjedetails/{id}"},method=RequestMethod.GET)
    public @ResponseBody
    Broodje getBroodje(@PathVariable("id") Integer id) {
        return broodjeRepository.findById(id);
    }

    @RequestMapping(value={"/createbroodje"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createBroodje(@Valid @RequestBody Broodje entry, Errors errors) {
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
            message = new StringBuilder("Het broodje " + broodje.getNaam() + " is succesvol aangemaakt");

        } catch (IllegalArgumentException e) {
        }
        return message.toString();
    }

    @RequestMapping(value={"/updatebroodje"},method=RequestMethod.PUT)
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
            message = new StringBuilder("Het broodje " + broodje.getNaam() + " is succesvol aangepast");

        } catch (IllegalArgumentException e) {
        }
        return message.toString();
    }

    @RequestMapping(value={"/deletebroodje/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBroodje(@PathVariable("id") Integer id){
        broodjeService.deleteBroodje(id);
    }



    @RequestMapping(value={"/createtestbroodje"},method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    void createTestKlant(){
        broodjeService.addTest();
    }

}
