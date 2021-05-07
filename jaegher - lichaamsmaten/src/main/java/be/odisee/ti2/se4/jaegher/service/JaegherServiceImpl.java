package be.odisee.ti2.se4.jaegher.service;

import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.DAO.LichaamsmaatRepository;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import be.odisee.ti2.se4.jaegher.formdata.EntryDataLichaamsmaat;
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
    LichaamsmaatRepository lichaamsmaatRepository;
    @Autowired
    GebruikerRepository gebruikerRepository;

    //Returned een list van alle klanten
    @Override
    public List<Gebruiker> getAllGebruikers() {
        return (List<Gebruiker>) gebruikerRepository.findAll();
    }
    @Override
    public List<Lichaamsmaat> getAllLichaamsmaten() {
        return (List<Lichaamsmaat>) lichaamsmaatRepository.findAll();
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
    public void deleteLichaamsmaat(long id){
        Lichaamsmaat lichaamsmaat = lichaamsmaatRepository.findById(id);
        lichaamsmaatRepository.delete(lichaamsmaat);
    }
    @Override
    public void addLichaamsmaat(Lichaamsmaat lichaamsmaat) {
        lichaamsmaatRepository.save(lichaamsmaat);
    }
    @Override
    public void updateLichaamsmaat(EntryDataLichaamsmaat entryData) {
        Lichaamsmaat lichaamsmaat;
        lichaamsmaat = lichaamsmaatRepository.findById(entryData.getId());
        lichaamsmaat.setLinkerBeen(entryData.getLinkerBeen());
        lichaamsmaat.setRechterBeen(entryData.getRechterBeen());
        lichaamsmaat.setBekkenkanteling(entryData.getBekkenkanteling());
        lichaamsmaat.setLinkerArm(entryData.getLinkerArm());
        lichaamsmaat.setGewicht(entryData.getGewicht());
        lichaamsmaat.setRechterArm(entryData.getRechterArm());
        lichaamsmaat.setGroote(entryData.getGroote());
        lichaamsmaatRepository.save(lichaamsmaat);
    }

    @Override
    public void addInitialLichaamsmaat() {
        Lichaamsmaat lichaamsmaat = new Lichaamsmaat();
        lichaamsmaat.setLinkerBeen(0.0);
        lichaamsmaat.setRechterBeen(0.0);
        lichaamsmaat.setBekkenkanteling(0.0);
        lichaamsmaat.setLinkerArm(0.0);
        lichaamsmaat.setGewicht(0.0);
        lichaamsmaat.setRechterArm(0.0);
        lichaamsmaat.setGroote(100.0);

        lichaamsmaatRepository.save(lichaamsmaat);
    }


}
