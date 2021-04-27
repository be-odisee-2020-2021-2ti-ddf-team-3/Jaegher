package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.service.JaegherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/jaegherrest", produces = "application/json")
// needed for CORS cookie passing from vue front and API tester respectively
@CrossOrigin(origins={"http://localhost:8888", "chrome-extension://aejoelaoggembcahagimdiliamlcdmfm"},
        maxAge = 3600, allowCredentials = "true")
public class JaegherRestController {

    @Autowired
    private KlantRepository klantRepository;

    @Autowired
    private JaegherService jaegherService;

    @GetMapping("/{id}")
    public Klant getEntrybyId(@PathVariable("id") Long id) {

        if (klantRepository.findById(id).isPresent()) {
            return klantRepository.findById(id).get();
        } else {
            return  null;
        }
    }
    @GetMapping("/klanten")
    public Object getObjectives(){
        return jaegherService.getAllKlanten();
    }
}
