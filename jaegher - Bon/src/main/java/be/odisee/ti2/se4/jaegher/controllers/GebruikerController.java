package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.service.JaegherServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@Slf4j
@Controller
@RequestMapping("/Gebruikers")
public class GebruikerController {
    @Autowired
    JaegherServiceImpl jaegherServiceImpl;
    @Autowired
    GebruikerRepository gebruikerRepository;

    @GetMapping
    public String Gebruiker(Model model) {
        Gebruiker gebruiker = new Gebruiker();
        model.addAttribute("gebruiker", gebruiker);
        model.addAttribute("gebruikers", jaegherServiceImpl.getAllGebruikers());
        return "Gebruikers";

    }
    @GetMapping("/edit")
    public String entryEditForm(@RequestParam("id") long id, Model model) {

        Gebruiker gebruiker = new Gebruiker();
        model.addAttribute("gebruiker", gebruiker);
        model.addAttribute("gebruikers", gebruikerRepository.findAllById(Collections.singleton(id)));
        return "Gebruikers";
    }


    @PostMapping(params = "submit")
    public String processEntry(@ModelAttribute("entryData") @Valid Gebruiker gebruiker, BindingResult result, Model model) {

        jaegherServiceImpl.addGebruiker(gebruiker);
        model.addAttribute("gebruiker", gebruiker);
        model.addAttribute("gebruikers", jaegherServiceImpl.getAllGebruikers());
        return "Gebruikers";
    }


}
