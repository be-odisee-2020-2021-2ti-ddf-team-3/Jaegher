package be.odisee.ti2.se4.jaegher.service;


import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import be.odisee.ti2.se4.jaegher.formdata.EntryDataLichaamsmaat;

import java.util.List;

public interface JaegherService {

    public List<Gebruiker> getAllGebruikers();

    public List<Lichaamsmaat> getAllLichaamsmaten();
    public String getAuthenticatedFullname();

    public String getAuthenticatedRole();

    public void addGebruiker(Gebruiker gebruiker);

    public void deleteLichaamsmaat(long id);
    public void addLichaamsmaat(Lichaamsmaat lichaamsmaat);
    public void updateLichaamsmaat(EntryDataLichaamsmaat entry);

    public void addInitialLichaamsmaat();

}
