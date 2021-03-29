package be.odisee.ti2.se4.jaegher.service;

import be.odisee.ti2.se4.jaegher.DAO.BestellingRepository;
import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.DAO.LichaamsmaatRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
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

    @Autowired
    LichaamsmaatRepository lichaamsmaatRepository;

    @Autowired
    BestellingRepository bestellingRepository;

    //Returned een list van alle klanten
    public List<Klant> getAllKlanten() {
        return (List<Klant>) klantRepository.findAll();

    }

    public void addKlant(EntryData entryData) {
        Klant entry;
        Lichaamsmaat lichaamsmaat = new Lichaamsmaat();

        lichaamsmaat.setLinkerBeen(0.0);
        lichaamsmaat.setRechterBeen(0.0);

        if (entryData.getId() == 0) entry = new Klant();
        else entry = klantRepository.findById(entryData.getId());

        entry.setLichaamsmaat(lichaamsmaat);
        String naam = entryData.getNaam();
        entry.setNaam(naam);
        String achternaam = entryData.getAchternaam();
        entry.setAchternaam(achternaam);
        String email = entryData.getEmail();
        entry.setEmail(email);
        klantRepository.save(entry);
    }
    public void addTest() {
        Klant klant = new Klant();
        Lichaamsmaat lichaamsmaat = new Lichaamsmaat();

        lichaamsmaat.setLinkerBeen(5.0);
        lichaamsmaat.setRechterBeen(7.0);

        klant.setLichaamsmaat(lichaamsmaat);
        klant.setNaam("Voornaam");
        klant.setAchternaam("Achternaam");
        klant.setEmail("Email@gmail.com");
        klantRepository.save(klant);
    }

    public void deleteKlant(long id) {
        klantRepository.deleteById(id);        
    }

    public void updateKlant(EntryData entryData, long id) {
        Klant klant;
        klant = klantRepository.findById(id);
        Lichaamsmaat lichaamsmaat;
        lichaamsmaat = klant.getLichaamsmaat();

        String naam = entryData.getNaam();
        klant.setNaam(naam);
        String achternaam = entryData.getAchternaam();
        klant.setAchternaam(achternaam);
        String email = entryData.getEmail();
        klant.setEmail(email);
        lichaamsmaat.setLinkerBeen(entryData.getLinkerBeen());
        lichaamsmaat.setRechterBeen(entryData.getRechterBeen());
        klant.setLichaamsmaat(lichaamsmaat);
        klantRepository.save(klant);
    }

    public EntryData prepareEntryDataToEdit(long id) {
        EntryData theEntryData = new EntryData();
        theEntryData.setId(id);
        return theEntryData;
    }

}
