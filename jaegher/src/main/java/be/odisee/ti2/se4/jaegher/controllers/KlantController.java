package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
import be.odisee.ti2.se4.jaegher.service.JaegherApplicationImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;


@Slf4j
@Controller
@RequestMapping("/klanten")
public class KlantController {
    @Autowired
    JaegherApplicationImpl jaegherApplication;
    @Autowired
    KlantRepository klantRepository;

    //Wanneer je de link http://localhost:8080/klanten ingeeft wordt je geredirect naar de view in locatie src/main/resources/templates/klanten.html
    @GetMapping
    public String klant(Model model) {
        Klant klant = new Klant();

        //Dit zorgt ervoor dat je klant en klanten kan gebruiken in de home view
        model.addAttribute(klant);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }

    @PostMapping(params = "submit")
    public String processEntry(Klant klant, Model model) {

       jaegherApplication.addKlant(klant);

        model.addAttribute(klant);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }

    @GetMapping("/edit")
    public String entryEditForm(@RequestParam("id") long id, Model model) {

        Klant klant = new Klant();
        klant = klantRepository.findById(id);
        model.addAttribute(klant);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }
    @PostMapping(params = "delete")
    public String deleteEntry(Klant entryKlant, Model model) {
        Klant klant = new Klant();
        klant = klantRepository.findById(entryKlant.getId());
        klantRepository.delete(klant);
        model.addAttribute(entryKlant);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }


}
