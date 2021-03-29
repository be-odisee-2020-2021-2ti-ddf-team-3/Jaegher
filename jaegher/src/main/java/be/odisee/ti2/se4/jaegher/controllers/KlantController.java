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
import java.util.Collections;
import java.util.Map;


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
        EntryData entryData = new EntryData();

        //Dit zorgt ervoor dat je klant en klanten kan gebruiken in de home view
        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }

    @PostMapping(params = "submit")
    public String processEntry(EntryData entryData, Model model) {

        jaegherApplication.addKlant(entryData);
        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }
    @PostMapping(params = "test")
    public String processEntry(Model model) {
        EntryData entryData = new EntryData();
        jaegherApplication.addTest();
        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }


    EntryData entryData = new EntryData();
    @PostMapping(params = "update")
    public String updateEntry(EntryData klant_, Model model) {
        jaegherApplication.updateKlant(klant_, entryData.getId());
        EntryData entryData = new EntryData();

        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }

    @GetMapping("/edit")
    public String entryEditForm(@RequestParam("id") long id, Model model) {

        entryData = jaegherApplication.prepareEntryDataToEdit(id);
        model.addAttribute(entryData);
        model.addAttribute("klanten", klantRepository.findAllById(Collections.singleton(id)));
        return "klanten";
    }

    @PostMapping(params = "delete")
    public String deleteEntry(Model model) {
        jaegherApplication.deleteKlant(entryData.getId());

        EntryData entryData = new EntryData();

        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherApplication.getAllKlanten());
        return "klanten";
    }


}
