package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.DAO.LichaamsmaatRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
import be.odisee.ti2.se4.jaegher.service.JaegherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/jaegherrestlichaamsmaat", produces = "application/json")
// needed for CORS cookie passing from vue front and API tester respectively
@CrossOrigin(origins={"http://localhost:8888"},
        maxAge = 3600, allowCredentials = "true")
public class JaegherRestControllerLichaamsmaten {

    @Autowired
    private LichaamsmaatRepository lichaamsmaatRepository;

    @Autowired
    private JaegherService jaegherService;

    //Gebruik deze om klant op ID op te vragen
    @RequestMapping(value={"/lichaamsmaatdetails/{id}"},method=RequestMethod.GET)
    public @ResponseBody Lichaamsmaat getKlant(@PathVariable("id") Integer id) {
        return lichaamsmaatRepository.findById(id);
    }

    @RequestMapping(value={"/deletelichaamsmaat/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLichaamsmaat(@PathVariable("id") Integer id){
        jaegherService.deleteLichaamsmaat(id);
    }

    @GetMapping("/lichaamsmaten")
    public Object getObjectives(){
        return jaegherService.getAllLichaamsmaten();
    }

    @RequestMapping(value={"/createlichaamsmaat"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Lichaamsmaat createKlant(@Valid @RequestBody Lichaamsmaat lichaamsmaat, Errors errors)
            throws BindException {
        jaegherService.addLichaamsmaat(lichaamsmaat);
        return lichaamsmaat;
    }

    @RequestMapping(value={"/updatelichaamsmaat/"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putLichaamsmaat(@Valid @RequestBody Lichaamsmaat lichaamsmaat, Errors errors){
        jaegherService.updateLichaamsmaat(lichaamsmaat);
    }

}
