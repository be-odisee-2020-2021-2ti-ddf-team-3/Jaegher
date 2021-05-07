package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
import be.odisee.ti2.se4.jaegher.service.JaegherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;

@RestController
@RequestMapping(path="/jaegherrest", produces = "application/json")
// needed for CORS cookie passing from vue front and API tester respectively
@CrossOrigin(origins={"http://localhost:8888"},
        maxAge = 3600, allowCredentials = "true")
public class JaegherRestController {

    @Autowired
    private KlantRepository klantRepository;

    @Autowired
    private JaegherService jaegherService;

    //Dit is een verouderde versie
    @GetMapping("/{id}")
    //@RequestMapping(value = {"/id"}, method = RequestMethod.GET)
    public Klant getEntrybyId(@PathVariable("id") Long id) {

        if (klantRepository.findById(id).isPresent()) {
            return klantRepository.findById(id).get();
        } else {
            return  null;
        }
    }

    //Gebruik deze om klant op ID op te vragen
    @RequestMapping(value={"/klantdetails/{id}"},method=RequestMethod.GET)
    public @ResponseBody Klant getKlant(@PathVariable("id") Integer id) {
        return klantRepository.findById(id);
    }

    @RequestMapping(value={"/deleteklant/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersoon(@PathVariable("id") Integer id){
        jaegherService.deleteKlant(id);
    }

    @RequestMapping(value={"/updateklant/"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putToestel(@Valid @RequestBody EntryData entry, Errors errors){
        EntryData klant = new EntryData();
        klant.setId(entry.getId());
        klant.setNaam(entry.getNaam());
        klant.setAchternaam(entry.getAchternaam());
        klant.setEmail(entry.getEmail());
        klant.setGeboortedatum(entry.getGeboortedatum());
        klant.setAddres(entry.getAddres());
        jaegherService.updateKlant(klant, entry.getId());
    }



    @GetMapping("/klanten")
    public Object getObjectives(){
        return jaegherService.getAllKlanten();

    }

    @RequestMapping(value={"/createtestklant"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody void createTestKlant(){
        jaegherService.addTest();
    }

    @RequestMapping(value={"/createklant"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EntryData createKlant(@Valid @RequestBody EntryData entry, Errors errors)
            throws BindException {
        EntryData klant = new EntryData();
        klant.setNaam(entry.getNaam());
        klant.setAchternaam(entry.getAchternaam());
        klant.setEmail(entry.getEmail());
        klant.setGeboortedatum(entry.getGeboortedatum());
        klant.setAddres(entry.getAddres());
        jaegherService.addKlant(klant);
        return klant;
    }
}
