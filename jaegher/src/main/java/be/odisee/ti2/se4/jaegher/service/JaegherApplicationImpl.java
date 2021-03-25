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
}
