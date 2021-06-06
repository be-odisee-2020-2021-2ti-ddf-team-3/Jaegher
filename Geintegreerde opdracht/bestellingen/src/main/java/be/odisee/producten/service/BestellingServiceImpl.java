package be.odisee.producten.service;

import be.odisee.producten.DAO.BestellingLijnRepository;
import be.odisee.producten.DAO.BestellingRepository;
import be.odisee.producten.dataKlassen.BestellingLijnModel;
import be.odisee.producten.dataKlassen.BestellingModel;
import be.odisee.producten.dataKlassen.EntryBestelling;
import be.odisee.producten.domain.Bestelling;
import be.odisee.producten.domain.BestellingLijn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Service
public class BestellingServiceImpl implements BestellingService{
    @Autowired
    BestellingLijnRepository bestellingLijnRepository;

    @Autowired
    BestellingRepository bestellingRepository;

    @Override
    public List<BestellingModel> getBestellingen(){
        List<Bestelling> myList = bestellingRepository.findAll();
        List<BestellingModel> myListModel = new ArrayList<>();

        for (Bestelling bes : myList)
        {
            List<BestellingLijn> lijnen = bestellingLijnRepository.findAllByBestelling_Id(bes.getId());
            List<BestellingLijnModel> lijnmodelen = new ArrayList<>();

            for (BestellingLijn lijn : lijnen) {
                lijnmodelen.add(new BestellingLijnModel(lijn.getId(), lijn.getProduct_naam(), lijn.getProduct_prijs(), lijn.getAantal(), lijn.getCommentaar(),  lijn.getBestelling().getId()));
            }

            myListModel.add( new BestellingModel(bes.getId(), bes.getTotale_prijs(), bes.getKlant_nummer(), bes.getBestelling_status(), bes.getBesteltijd(), lijnmodelen));
        }

        return myListModel;
    }
    @Override
    public BestellingModel getBestelling(Integer id) {
        Bestelling bestelling = bestellingRepository.findById(id);

        List<BestellingLijn> lijnen = bestellingLijnRepository.findAllByBestelling_Id(bestelling.getId());
        List<BestellingLijnModel> lijnmodelen = new ArrayList<>();

        for (BestellingLijn lijn : lijnen) {
            lijnmodelen.add(new BestellingLijnModel(lijn.getId(), lijn.getProduct_naam(), lijn.getProduct_prijs(), lijn.getAantal(), lijn.getCommentaar(), lijn.getBestelling().getId()));
        }

        BestellingModel myListModel = new BestellingModel(bestelling.getId(), bestelling.getTotale_prijs(), bestelling.getKlant_nummer(), bestelling.getBestelling_status(), bestelling.getBesteltijd(), lijnmodelen);

        return myListModel;
    }
    @Override
    public Bestelling addBestelling(Bestelling entryData) {
        LocalDateTime now = LocalDateTime.now();
        entryData.setBesteltijd(now.toString());
        bestellingRepository.save(entryData);
        return entryData;
    }
    @Override
    public Bestelling updateBestelling(EntryBestelling entryData, long id) {
        Bestelling bestelling = bestellingRepository.findById(id);
        bestelling.setTotale_prijs(entryData.getTotale_prijs());
        bestelling.setBestelling_status(entryData.getBestelling_status());
        bestelling.setKlant_nummer(entryData.getKlant_nummer());

        bestellingRepository.save(bestelling);
        return bestelling;
    }
    @Override
    public void deleteBestelling(long id){
        Bestelling product = bestellingRepository.findById(id);
        bestellingRepository.delete(product);
    }
}
