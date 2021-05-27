package be.odisee.producten.service;

import be.odisee.producten.dataKlassen.EntryBestellingLijn;
import be.odisee.producten.domain.BestellingLijn;

import java.util.List;

public interface ProductService {
    public void addTest();
    public BestellingLijn addBroodje(EntryBestellingLijn entryData);
    public List<BestellingLijn> getAllBroodjes();
    public BestellingLijn updateBroodje(EntryBestellingLijn entryData, long id);
    public void deleteBroodje(long id);
}
