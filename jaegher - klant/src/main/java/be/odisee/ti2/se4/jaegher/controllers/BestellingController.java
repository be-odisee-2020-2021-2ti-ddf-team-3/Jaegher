package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.DAO.BestellingRepository;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
import be.odisee.ti2.se4.jaegher.formdata.EntryDataBestellingen;
import be.odisee.ti2.se4.jaegher.service.JaegherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Controller
@RequestMapping("/Bestellingen")
public class BestellingController {
    @Autowired
    JaegherService jaegherService;
    @Autowired
    BestellingRepository bestellingRepository;

    EntryDataBestellingen entryData = new EntryDataBestellingen();
    Long klantID = null;

    @GetMapping
    public String Bestelling(Model model) {
        EntryData entryData = new EntryData();
        model.addAttribute(entryData);
        model.addAttribute("klanten", jaegherService.getAllKlanten());
        model.addAttribute("EditBestelling", 0);
        return "Bestellingen";
    }

    @GetMapping("/edit")
    public String entryEditForm(@RequestParam("id") long id, Model model) {
        entryData = jaegherService.prepareEntryDataBestellingenKlant(id);
        klantID = entryData.getKlantId();
        model.addAttribute("entryData", entryData);
        model.addAttribute("bestellingen", bestellingRepository.findAllByKlant_Id(klantID));
        model.addAttribute("EditBestelling", 0);
        return "Bestellingen";
    }
    @GetMapping("/editBestelling")
    public String entryEditFormBestelling(@RequestParam("id") long id, Model model) {
        entryData = jaegherService.prepareEntryDataBestelling(id);
        model.addAttribute("entryData", entryData);
        model.addAttribute("bestellingen", bestellingRepository.findAllByKlant_Id(klantID));
        model.addAttribute("EditBestelling", 1);
        return "Bestellingen";
    }
    @GetMapping("/test")
    public String entryTest(Model model) {
        jaegherService.addTestBestelling();
        EntryData entryData_ = new EntryData();
        model.addAttribute(entryData_);
        model.addAttribute("klanten", jaegherService.getAllKlanten());
        model.addAttribute("Bestellingen", jaegherService.getAllBestellingen());
        model.addAttribute("EditBestelling", 0);
        return "Bestellingen";
    }

    @PostMapping(params = "submit")
    public String processEntry(@ModelAttribute("entryData") @Valid EntryDataBestellingen entryData, Model model) {
         jaegherService.addBestelling(entryData, klantID);
         EntryData entryData_ = new EntryData();
         model.addAttribute(entryData_);
         model.addAttribute("klanten", jaegherService.getAllKlanten());
         model.addAttribute("Bestellingen", jaegherService.getAllBestellingen());
         model.addAttribute("EditBestelling", 0);
         return "Bestellingen";
    }

    @PostMapping(params = "update")
    public String updateEntry(@ModelAttribute("entryData") @Valid EntryDataBestellingen entryData, Model model) {
        jaegherService.updateBestelling(entryData, klantID);
        EntryData entryData_ = new EntryData();
        model.addAttribute(entryData_);
        model.addAttribute("klanten", jaegherService.getAllKlanten());
        model.addAttribute("Bestellingen", jaegherService.getAllBestellingen());
        model.addAttribute("EditBestelling", 0);
        return "Bestellingen";
    }
    @PostMapping(params = "goedkeuren")
    public String EntryGoedkeueren(@ModelAttribute("entryData") @Valid EntryDataBestellingen entryData, Model model) {
        jaegherService.bestellingGoedkeuren(klantID);
        EntryData entryData_ = new EntryData();
        model.addAttribute(entryData_);
        model.addAttribute("klanten", jaegherService.getAllKlanten());
        model.addAttribute("Bestellingen", jaegherService.getAllBestellingen());
        model.addAttribute("EditBestelling", 0);
        return "Bestellingen";
    }
    @PostMapping(params = "delete")
    public String deleteEntry(Model model) {
        jaegherService.deleteBestelling(entryData.getId());

        EntryData entryData_ = new EntryData();
        model.addAttribute(entryData_);
        model.addAttribute("klanten", jaegherService.getAllKlanten());
        model.addAttribute("Bestellingen", jaegherService.getAllBestellingen());
        model.addAttribute("EditBestelling", 0);
        return "Bestellingen";
    }
}
