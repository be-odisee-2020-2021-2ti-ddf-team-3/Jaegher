package be.odisee.ti2.groep4.quatraplanning.controllers;

import be.odisee.ti2.groep4.quatraplanning.service.QuatraPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class KlantController {

    @Autowired
    protected QuatraPlanningService quatraPlanningService = null;
    /**
    @GetMapping(value="/klantLijst")
    public String klantLijst(ModelMap model) {
        List<Klant> l = quatraPlanningService.geefAlleKlanten();
        model.addAttribute("klanten", l);
        return "/klantLijst";
    }
    */
}