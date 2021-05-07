package be.odisee.ti2.se4.jaegher.service;


import be.odisee.ti2.se4.jaegher.domain.Bestelling;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;
import be.odisee.ti2.se4.jaegher.formdata.EntryDataBestellingen;

import java.util.List;

public interface JaegherService {
    public List<Klant> getAllKlanten();

    public List<Gebruiker> getAllGebruikers();

    public List<Bestelling> getAllBestellingen();

    public List<Lichaamsmaat> getAllLichaamsmaten();

    public void addKlant(EntryData entryData);

    public void addTest();

    public void deleteKlant(long id);

    public void updateKlant(EntryData entryData, long id);

    public EntryData prepareEntryDataToEdit(long id);

    public String getAuthenticatedFullname();

    public String getAuthenticatedRole();

    public void addGebruiker(Gebruiker gebruiker);

    public EntryDataBestellingen prepareEntryDataBestellingenKlant(long id);
    public EntryDataBestellingen prepareEntryDataBestelling(long id) ;

    public void addBestelling(EntryDataBestellingen entryData, long klantID);

    public void updateBestelling(EntryDataBestellingen entryData, long id);
    public void bestellingGoedkeuren(long id) ;
    public void deleteBestelling(long id);
    public void addTestBestelling();

    public void deleteLichaamsmaat(long id);
    public void addLichaamsmaat(Lichaamsmaat lichaamsmaat);
    public void updateLichaamsmaat(Lichaamsmaat entry);


}
