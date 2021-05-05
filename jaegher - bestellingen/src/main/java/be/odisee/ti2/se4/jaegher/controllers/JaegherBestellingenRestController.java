package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.BestellingRepository;
import be.odisee.ti2.se4.jaegher.domain.Bestelling;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
import be.odisee.ti2.se4.jaegher.formdata.EntryDataBestellingen;
import be.odisee.ti2.se4.jaegher.service.JaegherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/jaegherrestbestellingen", produces = "application/json")
// needed for CORS cookie passing from vue front and API tester respectively
@CrossOrigin(origins="http://localhost:8888",
        maxAge = 3600, allowCredentials = "true")
public class JaegherBestellingenRestController {

    @Autowired
    private JaegherService jaegherService;

    @Autowired
    BestellingRepository bestellingRepository;

    @RequestMapping(value={"/createbestelling"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EntryDataBestellingen createBestelling(@Valid @RequestBody EntryDataBestellingen entry, Errors errors)
            throws BindException {
        EntryDataBestellingen klant = new EntryDataBestellingen();
        klant.setNaam(entry.getNaam());
        klant.setKlantId(entry.getKlantId());
        klant.setVoorNaam(entry.getVoorNaam());
        klant.setAchterNaam(entry.getAchterNaam());
        klant.setAanMaakDatum(entry.getAanMaakDatum());
        jaegherService.addBestelling(klant, entry.getKlantId());
        return klant;
    }

    @RequestMapping(value={"/updatebestelling"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EntryDataBestellingen updateBestelling(@Valid @RequestBody EntryDataBestellingen entry, Errors errors)
            throws BindException {
        EntryDataBestellingen klant = new EntryDataBestellingen();
        klant.setNaam(entry.getNaam());
        klant.setKlantId(entry.getKlantId());
        klant.setAanMaakDatum(entry.getAanMaakDatum());
        jaegherService.updateBestelling(klant, entry.getKlantId());
        return klant;
    }

    @RequestMapping(value={"/bestellinggoedkeuren"},method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public EntryDataBestellingen bestellingGoedkeueren(@Valid @RequestBody long id, Errors errors)
            throws BindException {
        jaegherService.bestellingGoedkeuren(id);
        return null;
    }

    @RequestMapping(value={"/bestellinggoedkeuren/{id}"},method=RequestMethod.PUT)
    public @ResponseBody
    Klant getKlant(@PathVariable("id") Integer id) {
        jaegherService.bestellingGoedkeuren(id);
        return null;
    }

    //Gebruik deze om klant op ID op te vragen
    @RequestMapping(value={"/bestellingdetails/{id}"},method=RequestMethod.GET)
    public @ResponseBody Bestelling getBestelling(@PathVariable("id") Integer id) {
        return bestellingRepository.findById(id);
    }

    @RequestMapping(value={"/deletebestelling/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBestelling (@PathVariable("id") Integer id){
        jaegherService.deleteBestelling(id);
    }

    @GetMapping("/bestellingen")
    public @ResponseBody
    List<Bestelling> getObjectives(){
        return jaegherService.getAllBestellingen();
    }

    @RequestMapping(value={"/createtestbestelling"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody void createTestBestelling(){
        jaegherService.addTestBestelling();
    }
}
