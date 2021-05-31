package be.odisee.producten.service;

import be.odisee.producten.dataKlassen.BestellingModel;
import be.odisee.producten.dataKlassen.EntryBestelling;
import be.odisee.producten.domain.Bestelling;

import java.util.List;

public interface BestellingService {
    List<BestellingModel> getBestellingen();
    public BestellingModel getBestelling(Integer id);
    public Bestelling addBestelling(Bestelling entryData);
    Bestelling updateBestelling(EntryBestelling entryData, long id);
    public void deleteBestelling(long id);
}
