package be.odisee.producten.service;

import be.odisee.producten.dataKlassen.EntryBestellingLijn;
import be.odisee.producten.domain.BestellingLijn;

import java.util.List;

public interface BestellingLijnService {
    public BestellingLijn addBestellingLijn(EntryBestellingLijn entryData);
    public List<BestellingLijn> getAllLijnen();
    public BestellingLijn updateLijn(EntryBestellingLijn entryData, long id);
    public void deleteLijn(long id);
}
