package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
import be.odisee.ti2.se4.jaegher.service.JaegherService;
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
@RequestMapping("/klanten")
public class KlantController {
    @Autowired
    KlantRepository klantRepository;

    @Autowired
    JaegherService jaegherService;

    EntryData entryData = new EntryData();


    //Wanneer je de link http://localhost:8080/klanten ingeeft wordt je geredirect naar de view in locatie src/main/resources/templates/klanten.html

    @GetMapping
    public String klant(Model model) {
        EntryData entryData = new EntryData();

        //Dit zorgt ervoor dat je klant en klanten kan gebruiken in de home view
        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherService.getAllKlanten());
        return "klanten";
    }

    @PostMapping(params = "submit")
    public String processEntry(@ModelAttribute("entryData") @Valid EntryData entryData, BindingResult result, Model model) {

        if (result.hasErrors()){
            return "klanten";
        }

        if(entryData.getId() == 0){
            jaegherService.addKlant(entryData);
            model.addAttribute(entryData);
            model.addAttribute("klanten", jaegherService.getAllKlanten());
            return "klanten";
        }else {
            jaegherService.updateKlant(entryData, entryData.getId());
            EntryData entryDataUpdate = new EntryData();
            model.addAttribute(entryDataUpdate);
            model.addAttribute("klanten", jaegherService.getAllKlanten());
            return "klanten";
        }
    }

    @PostMapping(params = "test")
    public String processEntry(Model model) {
        EntryData entryData = new EntryData();
        jaegherService.addTest();
        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherService.getAllKlanten());
        return "klanten";
    }

    @GetMapping("/edit")
    public String entryEditForm(@RequestParam("id") long id, Model model) {

        entryData = jaegherService.prepareEntryDataToEdit(id);
        model.addAttribute("entryData", entryData);
        model.addAttribute("klanten", klantRepository.findAllById(Collections.singleton(id)));
        return "klanten";
    }

    @PostMapping(params = "delete")
    public String deleteEntry(Model model) {
        jaegherService.deleteKlant(entryData.getId());

        EntryData entryData = new EntryData();

        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherService.getAllKlanten());
        return "klanten";
    }


}
