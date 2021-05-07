package be.odisee.ti2.se4.jaegher.service;

import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
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
    KlantRepository klantRepository;
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
    public void addKlant(EntryData entryData) {
        Klant entry;
        if (entryData.getId() == 0) entry = new Klant();
        else entry = klantRepository.findById(entryData.getId());

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

        klant.setNaam(entryData.getNaam());
        klant.setAchternaam(entryData.getAchternaam());
        klant.setEmail(entryData.getEmail());
        klant.setAddres(entryData.getAddres());
        klant.setGeboortedatum(entryData.getGeboortedatum());

        klantRepository.save(klant);
    }

    @Override
    public EntryData prepareEntryDataToEdit(long id) {
        EntryData theEntryData = new EntryData();
        Klant klant = klantRepository.findById(id);

        theEntryData.setId(id);
        theEntryData.setAchternaam(klant.getAchternaam());
        theEntryData.setNaam(klant.getNaam());
        theEntryData.setAddres(klant.getAddres());
        theEntryData.setEmail(klant.getEmail());
        theEntryData.setGeboortedatum(klant.getGeboortedatum());

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


}
