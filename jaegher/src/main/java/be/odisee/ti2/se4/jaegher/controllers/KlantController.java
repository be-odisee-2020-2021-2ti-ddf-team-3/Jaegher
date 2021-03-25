package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.service.JaegherApplicationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KlantController {
    @Autowired
    JaegherApplicationImpl jaegherApplication;

    //Wanneer je de link http://localhost:8080/klanten ingeeft wordt je geredirect naar de view in locatie src/main/resources/templates/klanten.html
    @GetMapping("/klanten")
    public String klant(Model model) {
        Klant klant = new Klant();

        //Dit zorgt ervoor dat je klant en klanten kan gebruiken in de home view
        model.addAttribute(klant);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }


}
