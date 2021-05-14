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
    public void addBestelling(EntryDataBestellingen entryData, long klantID) {
        Bestelling entry = new Bestelling();

        String date = entryData.getDatum();
        entry.setDatum(date);

        bestellingRepository.save(entry);
    }


}
