package be.odisee.ti2.groep4.quatraplanning.controllers;

import be.odisee.ti2.groep4.quatraplanning.domain.Afspraak;
import be.odisee.ti2.groep4.quatraplanning.service.QuatraPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class AfspraakController {

    @Autowired
    protected QuatraPlanningService quatraPlanningService = null;

    @GetMapping(value="/afspraakLijst")
    public String afspraakLijst(ModelMap model) {
        List<Afspraak> l = quatraPlanningService.geefAlleAfspraken();
        model.addAttribute("afspraken", l);
        return "/afspraakLijst";
    }


    /********
     * READ *
     ********/
    @GetMapping("/afspraak")
    public String afspraakTonen(@RequestParam("id") long id, Model model){
        Afspraak a = quatraPlanningService.zoekAfspraakMetId(id);
        model.addAttribute("afspraak", a);
        List<Afspraak> azp = quatraPlanningService.geefAfsprakenZonderPlanning();
        model.addAttribute("afspraken2", azp);
        return "/afspraak";
    }

}