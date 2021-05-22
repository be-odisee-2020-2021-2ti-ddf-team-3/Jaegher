package be.odisee.broodjes.service;

import be.odisee.broodjes.DAO.BroodjeRepository;
import be.odisee.broodjes.dataKlassen.EntryBroodje;
import be.odisee.broodjes.domain.Broodje;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Slf4j
@Service
public class BroodjeServiceImpl implements BroodjeService {

    @Autowired
    BroodjeRepository broodjeRepository;

    @Override
    public List<Broodje> getAllBroodjes() {
        return (List<Broodje>) broodjeRepository.findAll();
    }

    @Override
    public void addTest() {
        Broodje klant = new Broodje();
        klant.setNaam("Voornaam");
        broodjeRepository.save(klant);
    }
    @Override
    public Broodje addBroodje(Broodje entryData) {
        Broodje entry = new Broodje();

        String naam = entryData.getNaam();
        entry.setNaam(naam);
        String beschrijving = entryData.getBeschrijving();
        entry.setBeschrijving(beschrijving);
        Double prijs = entryData.getPrijs();
        entry.setPrijs(prijs);
        entry.setBeschikbaar(false);
        broodjeRepository.save(entry);
        return entry;
    }


    @Override
    public Broodje updateBroodje(EntryBroodje entryData, long id) {
        Broodje broodje = broodjeRepository.findById(id);
        broodje.setNaam(entryData.getNaam());
        broodje.setBeschrijving(entryData.getBeschrijving());
        broodje.setPrijs(entryData.getPrijs());

        broodjeRepository.save(broodje);
        return broodje;
    }

    @Override
    public void deleteBroodje(long id){
        Broodje broodje = broodjeRepository.findById(id);
        broodjeRepository.delete(broodje);
    }

    @Override
    public void updateStatus(long id){
        Broodje broodje = broodjeRepository.findById(id);
        if (broodje.isBeschikbaar()){
            broodje.setBeschikbaar(false);
        }
        else{
            broodje.setBeschikbaar(true);
        }
        broodjeRepository.save(broodje);
    }
}
