package be.odisee.ti2.se4.jaegher.service;


import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.formdata.EntryData;

import java.util.List;

public interface JaegherService {
    public List<Klant> getAllKlanten();

    public void addKlant(EntryData entryData);

    public void addTest();

    public void deleteKlant(long id);

    public void updateKlant(EntryData entryData, long id);

    public EntryData prepareEntryDataToEdit(long id);

    public String getAuthenticatedFullname();

    public String getAuthenticatedRole();
}
