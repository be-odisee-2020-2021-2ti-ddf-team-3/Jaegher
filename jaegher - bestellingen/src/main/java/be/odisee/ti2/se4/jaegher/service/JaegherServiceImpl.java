package be.odisee.ti2.se4.jaegher.service;

import be.odisee.ti2.se4.jaegher.DAO.BestellingRepository;
import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.domain.Bestelling;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.formdata.EntryDataBestellingen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;import org.springframework.security.crypto.bcrypt.BCrypt;

//Deze klassen moet ook een interface krijgen enkel interface mag gebruikt worden
@Slf4j
@Service
public class JaegherServiceImpl implements JaegherService {
    @Autowired
    BestellingRepository bestellingRepository;
    @Autowired
    GebruikerRepository gebruikerRepository;

    //Returned een list van alle klanten
    @Override
    public List<Gebruiker> getAllGebruikers() {
        return (List<Gebruiker>) gebruikerRepository.findAll();
    }
    @Override
    public List<Bestelling> getAllBestellingen() {
        return (List<Bestelling>) bestellingRepository.findAll();
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

        entry.setKlantId(entryData.getKlantId());
        entry.setPlanningId(entryData.getPlanningId());
        String naam = entryData.getNaam();
        entry.setNaam(naam);
        String date = entryData.getAanMaakDatum();
        entry.setAanMaakDatum(date);
        entry.setGoedgekeurd(false);

        bestellingRepository.save(entry);
    }
    @Override
    public void addTestBestelling() {
        Bestelling entry = new Bestelling();

        entry.setKlantId(1);
        String naam = "naam";
        entry.setNaam(naam);
        String date = "2001-05-02";
        entry.setAanMaakDatum(date);
        entry.setGoedgekeurd(false);

        bestellingRepository.save(entry);
    }

    @Override
    public void updateBestelling(EntryDataBestellingen entryData, long id) {
        Bestelling bestelling;
        bestelling = bestellingRepository.findById(entryData.getId());

        bestelling.setNaam(entryData.getNaam());
        bestelling.setAanMaakDatum(entryData.getAanMaakDatum());
        bestelling.setKlantId(entryData.getKlantId());
        bestelling.setGoedgekeurd(entryData.getGoedgekeurd());
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
