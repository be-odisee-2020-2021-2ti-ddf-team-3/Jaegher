package be.odisee.ti2.se4.jaegher.service;


import be.odisee.ti2.se4.jaegher.domain.Bestelling;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.formdata.EntryDataBestellingen;

import java.util.List;

public interface JaegherService {

    public List<Gebruiker> getAllGebruikers();

    public List<Bestelling> getAllBestellingen();

    public String getAuthenticatedFullname();

    public String getAuthenticatedRole();

    public void addGebruiker(Gebruiker gebruiker);

    public void addBestelling(EntryDataBestellingen entryData, long klantID);




}
