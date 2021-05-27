package be.odisee.producten.controllers;

import be.odisee.producten.DAO.BestellingLijnRepository;
import be.odisee.producten.DAO.BestellingRepository;
import be.odisee.producten.dataKlassen.BestellingModel;
import be.odisee.producten.domain.Bestelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/categorieen", produces = "application/json")
public class BestellingController {
    @Autowired
    private BestellingRepository bestellingRepository;

    @Autowired
    private BestellingLijnRepository bestellingLijnRepository;

    /**
     * Returned een lijst van alle categorieen
     */
    @GetMapping("/list")
    public Object getObjectives(){
        List<Bestelling> myList = bestellingRepository.findAll();
        List<BestellingModel> myListModel = new ArrayList<>();

        for (Bestelling bes : myList)
        {
            myListModel.add( new BestellingModel(bes.getId(), bes.getNaam(), bestellingLijnRepository.findAllByBestelling_Id(bes.getId())));
        }

        return myListModel;
    }
}
