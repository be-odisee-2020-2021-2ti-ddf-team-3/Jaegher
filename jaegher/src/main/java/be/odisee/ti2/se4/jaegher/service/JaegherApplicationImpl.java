package be.odisee.ti2.se4.jaegher.service;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Deze klassen moet ook een interface krijgen enkel interface mag gebruikt worden
@Slf4j
@Service
public class JaegherApplicationImpl {
    @Autowired
    KlantRepository klantRepository;

    //Returned een list van alle klanten
    public List<Klant> getAllKlanten() {
        return (List<Klant>) klantRepository.findAll();

    }

    public void addKlant(Klant entryData) {

        Klant entry;

        if (entryData.getId() == 0) entry = new Klant();
        else entry = klantRepository.findById(entryData.getId());

        String naam = entryData.getNaam();
        entry.setNaam(naam);
        String achternaam = entryData.getAchternaam();
        entry.setAchternaam(achternaam);


        klantRepository.save(entry);
    }
}
