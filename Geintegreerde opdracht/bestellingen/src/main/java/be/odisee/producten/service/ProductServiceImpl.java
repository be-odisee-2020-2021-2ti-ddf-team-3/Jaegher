package be.odisee.producten.service;

import be.odisee.producten.DAO.BestellingLijnRepository;
import be.odisee.producten.DAO.BestellingRepository;
import be.odisee.producten.dataKlassen.EntryBestellingLijn;
import be.odisee.producten.domain.BestellingLijn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    BestellingLijnRepository bestellingLijnRepository;

    @Autowired
    BestellingRepository bestellingRepository;

    @Override
    public List<BestellingLijn> getAllBroodjes() {
        return (List<BestellingLijn>) bestellingLijnRepository.findAll();
    }

    @Override
    public void addTest() {
        BestellingLijn klant = new BestellingLijn();
        klant.setNaam("Voornaam");
        bestellingLijnRepository.save(klant);
    }
    @Override
    public BestellingLijn addBroodje(EntryBestellingLijn entryData) {
        BestellingLijn entry = new BestellingLijn();

        String naam = entryData.getNaam();
        entry.setNaam(naam);
        entry.setBestelling(bestellingRepository.getById(entryData.getBestellingId()));
        bestellingLijnRepository.save(entry);
        return entry;
    }


    @Override
    public BestellingLijn updateBroodje(EntryBestellingLijn entryData, long id) {
        BestellingLijn bestellingLijn = bestellingLijnRepository.findById(id);
        bestellingLijn.setNaam(entryData.getNaam());

        bestellingLijnRepository.save(bestellingLijn);
        return bestellingLijn;
    }

    @Override
    public void deleteBroodje(long id){
        BestellingLijn bestellingLijn = bestellingLijnRepository.findById(id);
        bestellingLijnRepository.delete(bestellingLijn);
    }

}
