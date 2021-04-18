package be.odisee.ti2.se4.jaegher.service;

import be.odisee.ti2.se4.jaegher.DAO.BestellingRepository;
import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.DAO.LichaamsmaatRepository;
import be.odisee.ti2.se4.jaegher.domain.Bestelling;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
import be.odisee.ti2.se4.jaegher.formdata.EntryDataBestellingen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;import org.springframework.security.crypto.bcrypt.BCrypt;

//Deze klassen moet ook een interface krijgen enkel interface mag gebruikt worden
@Slf4j
@Service
public class JaegherServiceImpl implements JaegherService {
    @Autowired
    KlantRepository klantRepository;
    @Autowired
    LichaamsmaatRepository lichaamsmaatRepository;
    @Autowired
    BestellingRepository bestellingRepository;
    @Autowired
    GebruikerRepository gebruikerRepository;

    //Returned een list van alle klanten
    @Override
    public List<Klant> getAllKlanten() {
        return (List<Klant>) klantRepository.findAll();
    }
    @Override
    public List<Gebruiker> getAllGebruikers() {
        return (List<Gebruiker>) gebruikerRepository.findAll();
    }
    @Override
    public List<Bestelling> getAllBestellingen() {
        return (List<Bestelling>) bestellingRepository.findAll();
    }

    @Override
    public void addKlant(EntryData entryData) {
        Klant entry;
        Lichaamsmaat lichaamsmaat = new Lichaamsmaat();

        lichaamsmaat.setLinkerBeen(0.0);
        lichaamsmaat.setRechterBeen(0.0);
        lichaamsmaat.setBekkenkanteling(0.0);
        lichaamsmaat.setLinkerArm(0.0);
        lichaamsmaat.setGewicht(0.0);
        lichaamsmaat.setRechterArm(0.0);
        lichaamsmaat.setGroote(100.0);

        if (entryData.getId() == 0) entry = new Klant();
        else entry = klantRepository.findById(entryData.getId());

        entry.setLichaamsmaat(lichaamsmaat);
        String naam = entryData.getNaam();
        entry.setNaam(naam);
        String achternaam = entryData.getAchternaam();
        entry.setAchternaam(achternaam);
        String email = entryData.getEmail();
        entry.setEmail(email);
        String addres = entryData.getAddres();
        entry.setAddres(addres);
        String date = entryData.getGeboortedatum();
        entry.setGeboortedatum(date);
        klantRepository.save(entry);
    }
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    @Override
    public void addGebruiker(Gebruiker gebruiker) {
        Gebruiker entry = new Gebruiker();

        //entry.setUsername(gebruiker.getUsername());
        //entry.setRole(gebruiker.getRole());
        //String pwd = hash(gebruiker.getPassword());
        //entry.setPassword(pwd);
        gebruikerRepository.save(entry);
    }
    @Override
    public void addTest() {
        Klant klant = new Klant();
        Lichaamsmaat lichaamsmaat = new Lichaamsmaat();

        lichaamsmaat.setLinkerBeen(85.5);
        lichaamsmaat.setRechterBeen(86.0);
        lichaamsmaat.setBekkenkanteling(15.0);
        lichaamsmaat.setGewicht(72.0);
        lichaamsmaat.setLinkerArm(53.0);
        lichaamsmaat.setRechterArm(52.0);
        lichaamsmaat.setGroote(172.0);

        klant.setLichaamsmaat(lichaamsmaat);
        klant.setNaam("Voornaam");
        klant.setAchternaam("Achternaam");
        klant.setEmail("Email@gmail.com");
        klant.setGeboortedatum("1979-05-06");
        klant.setAddres("GebakkeStraat 17, Edingen");
        klantRepository.save(klant);
    }

    @Override
    public void deleteKlant(long id){
        Klant klant = klantRepository.findById(id);
        klantRepository.delete(klant);
    }

    @Override
    public void updateKlant(EntryData entryData, long id) {
        Klant klant;
        klant = klantRepository.findById(id);
        Lichaamsmaat lichaamsmaat;
        lichaamsmaat = klant.getLichaamsmaat();

        klant.setNaam(entryData.getNaam());
        klant.setAchternaam(entryData.getAchternaam());
        klant.setEmail(entryData.getEmail());
        klant.setAddres(entryData.getAddres());
        klant.setGeboortedatum(entryData.getGeboortedatum());

        lichaamsmaat.setLinkerBeen(entryData.getLinkerBeen());
        lichaamsmaat.setRechterBeen(entryData.getRechterBeen());
        lichaamsmaat.setBekkenkanteling(entryData.getBekkenkanteling());
        lichaamsmaat.setLinkerArm(entryData.getLinkerArm());
        lichaamsmaat.setGewicht(entryData.getGewicht());
        lichaamsmaat.setRechterArm(entryData.getRechterArm());
        lichaamsmaat.setGroote(entryData.getGroote());
        klant.setLichaamsmaat(lichaamsmaat);
        klantRepository.save(klant);
    }

    @Override
    public EntryData prepareEntryDataToEdit(long id) {
        EntryData theEntryData = new EntryData();
        Klant klant = klantRepository.findById(id);
        Lichaamsmaat lichaamsmaat = klant.getLichaamsmaat();

        theEntryData.setId(id);
        theEntryData.setAchternaam(klant.getAchternaam());
        theEntryData.setNaam(klant.getNaam());
        theEntryData.setAddres(klant.getAddres());
        theEntryData.setEmail(klant.getEmail());
        theEntryData.setGeboortedatum(klant.getGeboortedatum());
        theEntryData.setLinkerArm(lichaamsmaat.getLinkerArm());
        theEntryData.setBekkenkanteling(lichaamsmaat.getBekkenkanteling());
        theEntryData.setRechterArm(lichaamsmaat.getRechterArm());
        theEntryData.setGewicht(lichaamsmaat.getGewicht());
        theEntryData.setRechterBeen(lichaamsmaat.getRechterBeen());
        theEntryData.setLinkerBeen(lichaamsmaat.getLinkerBeen());
        theEntryData.setGroote(lichaamsmaat.getGroote());

        return theEntryData;
    }

    public String getAuthenticatedUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }
    private Gebruiker findAuthenticatedUser() {

        String username = getAuthenticatedUsername();
        return gebruikerRepository.findByUsername(username);
    }

    @Override
    public String getAuthenticatedFullname() {

        Gebruiker theUser = findAuthenticatedUser();
        return theUser.getUsername();
    }
    @Override
    public String getAuthenticatedRole() {
        Gebruiker theUser = findAuthenticatedUser();
        return theUser.getRole();
    }

    @Override
    public EntryDataBestellingen prepareEntryDataBestellingenKlant(long id) {
        EntryDataBestellingen theEntryData = new EntryDataBestellingen();
        Klant klant = klantRepository.findById(id);

        theEntryData.setId(id);
        theEntryData.setBestellingId(0);
        theEntryData.setAchterNaam(klant.getAchternaam());
        theEntryData.setVoorNaam(klant.getNaam());
        theEntryData.setKlantId(klant.getId());

        return theEntryData;
    }
    @Override
    public EntryDataBestellingen prepareEntryDataBestelling(long id) {
        EntryDataBestellingen theEntryData = new EntryDataBestellingen();
        Bestelling bestelling = bestellingRepository.findById(id);

        theEntryData.setId(id);
        theEntryData.setBestellingId(bestelling.getId());
        theEntryData.setNaam(bestelling.getNaam());
        theEntryData.setAanMaakDatum(bestelling.getAanMaakDatum());

        return theEntryData;
    }
    @Override
    public void addBestelling(EntryDataBestellingen entryData, long klantID) {
        Bestelling entry = new Bestelling();

        Klant klant = klantRepository.findById(klantID);
        entry.setKlant(klant);
        String naam = entryData.getNaam();
        entry.setNaam(naam);
        String date = entryData.getAanMaakDatum();
        entry.setAanMaakDatum(date);
        entry.setGoedgekeurd(false);

        bestellingRepository.save(entry);
    }

    @Override
    public void updateBestelling(EntryDataBestellingen entryData, long id) {
        Bestelling bestelling;
        bestelling = bestellingRepository.findById(id);

        bestelling.setNaam(entryData.getNaam());
        bestelling.setAanMaakDatum(entryData.getAanMaakDatum());
        bestellingRepository.save(bestelling);
    }
    @Override
    public void bestellingGoedkeuren(long id) {
        Bestelling bestelling;
        bestelling = bestellingRepository.findById(id);

        bestelling.setGoedgekeurd(true);
        bestellingRepository.save(bestelling);
    }

    @Override
    public void deleteBestelling(long id){
        Bestelling bestelling = bestellingRepository.findById(id);
        bestellingRepository.delete(bestelling);
    }

}
