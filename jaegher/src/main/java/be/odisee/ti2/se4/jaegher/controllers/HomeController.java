package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.service.JaegherApplicationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    JaegherApplicationImpl jaegherApplication;
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    //Wanneer je de link http://localhost:8080/home ingeeft wordt je geredirect naar de view in locatie src/main/resources/templates/home.html
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    //Dit werkt niet, ik probeer du button op het home view om naar de klanten view te gaan te doen werken
    @PostMapping(params = "btnklanten")
    public String gotToKlanten(Model model) {
        Klant klant = new Klant();

        //Dit zorgt ervoor dat je klant en klanten kan gebruiken in de home view
        model.addAttribute(klant);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }
}
