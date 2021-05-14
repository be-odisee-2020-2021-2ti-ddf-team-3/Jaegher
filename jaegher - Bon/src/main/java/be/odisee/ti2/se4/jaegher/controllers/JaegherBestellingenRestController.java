package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.BestellingRepository;
import be.odisee.ti2.se4.jaegher.domain.Bestelling;
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
@RequestMapping(path="/jaegherbonnen", produces = "application/json")
// needed for CORS cookie passing from vue front and API tester respectively
@CrossOrigin(origins="http://localhost:8888",
        maxAge = 3600, allowCredentials = "true")
public class JaegherBestellingenRestController {

    @Autowired
    private JaegherService jaegherService;

    @Autowired
    BestellingRepository bestellingRepository;

    @RequestMapping(value={"/createbon"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EntryDataBestellingen createBestelling(@Valid @RequestBody EntryDataBestellingen entry, Errors errors)
            throws BindException {
        EntryDataBestellingen klant = new EntryDataBestellingen();
        klant.setDatum(entry.getDatum());
        jaegherService.addBestelling(klant, 1);
        return klant;
    }

    @RequestMapping(value={"/bondetails/{id}"},method=RequestMethod.GET)
    public @ResponseBody Bestelling getBestelling(@PathVariable("id") Integer id) {
        return bestellingRepository.findById(id);
    }

    @GetMapping("/bonnen")
    public @ResponseBody
    List<Bestelling> getObjectives(){
        return jaegherService.getAllBestellingen();
    }

}
