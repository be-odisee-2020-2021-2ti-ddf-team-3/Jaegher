package be.odisee.producten.service;

import be.odisee.producten.DAO.BestellingLijnRepository;
import be.odisee.producten.DAO.BestellingRepository;
import be.odisee.producten.dataKlassen.BestellingLijnModel;
import be.odisee.producten.dataKlassen.BestellingModel;
import be.odisee.producten.dataKlassen.EntryBestellingLijn;
import be.odisee.producten.domain.Bestelling;
import be.odisee.producten.domain.BestellingLijn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BestellingLijnServiceImpl implements BestellingLijnService {

    @Autowired
    BestellingLijnRepository bestellingLijnRepository;

    @Autowired
    BestellingRepository bestellingRepository;

    @Override
    public List<BestellingLijn> getAllLijnen() {
        return (List<BestellingLijn>) bestellingLijnRepository.findAll();
    }

    @Override
    public BestellingLijn addBestellingLijn(EntryBestellingLijn entryData) {
        BestellingLijn entry = new BestellingLijn();

        String naam = entryData.getProduct_naam();
        entry.setProduct_naam(naam);
        double prijs = entryData.getProduct_prijs();
        entry.setProduct_prijs(prijs);
        int aantal = entryData.getAantal();
        entry.setAantal(aantal);
        String commentaar = entryData.getCommentaar();
        entry.setCommentaar(commentaar);
        int productId = entryData.getProductId();
        entry.setProductId(productId);
        entry.setBestelling(bestellingRepository.getById(entryData.getBestelnummer()));
        bestellingLijnRepository.save(entry);
        return entry;
    }


    @Override
    public BestellingLijn updateLijn(EntryBestellingLijn entryData, long id) {
        BestellingLijn bestellingLijn = bestellingLijnRepository.findById(id);
        bestellingLijn.setProduct_naam(entryData.getProduct_naam());
        bestellingLijn.setProduct_prijs(entryData.getProduct_prijs());
        bestellingLijn.setCommentaar(entryData.getCommentaar());
        bestellingLijn.setProductId(entryData.getProductId());
        bestellingLijn.setAantal(entryData.getAantal());

        bestellingLijnRepository.save(bestellingLijn);
        return bestellingLijn;
    }

    @Override
    public void deleteLijn(long id){
        BestellingLijn bestellingLijn = bestellingLijnRepository.findById(id);
        bestellingLijnRepository.delete(bestellingLijn);
    }
    @Override
    public BestellingLijnModel getBestellingLijn(Integer id) {
        BestellingLijn bestelling = bestellingLijnRepository.findById(id);
        BestellingLijnModel model = new BestellingLijnModel(bestelling.getId(), bestelling.getProduct_naam(), bestelling.getProduct_prijs(), bestelling.getAantal(), bestelling.getCommentaar(), bestelling.getProductId(), bestelling.getBestelnummer());


        return model;
    }

}
