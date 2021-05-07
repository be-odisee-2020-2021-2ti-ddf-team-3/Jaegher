package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.formdata.EntryDataBestellingen;
import be.odisee.ti2.se4.jaegher.service.JaegherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/jaegherrestbestellingen", produces = "application/json")
// needed for CORS cookie passing from vue front and API tester respectively
@CrossOrigin(origins={"http://localhost:8888"},
        maxAge = 3600, allowCredentials = "true")
public class JaegherBestellingenRestController {

    @Autowired
    private JaegherService jaegherService;

    @RequestMapping(value={"/createbestelling"},method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EntryDataBestellingen createKlant(@Valid @RequestBody EntryDataBestellingen entry, Errors errors)
            throws BindException {
        jaegherService.addTestBestelling();
        return null;
    }
    @GetMapping("/bestellingen")
    public Object getObjectives(){
        return jaegherService.getAllBestellingen();

    }

    @RequestMapping(value={"/createtestbestelling"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody void createTestBestelling(){
        jaegherService.addTestBestelling();
    }
}
