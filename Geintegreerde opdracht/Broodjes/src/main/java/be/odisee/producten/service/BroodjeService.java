package be.odisee.producten.service;

import be.odisee.producten.dataKlassen.EntryBroodje;
import be.odisee.producten.domain.Broodje;

import java.util.List;

public interface BroodjeService {
    public void addTest();
    public Broodje addBroodje(EntryBroodje entryData);
    public List<Broodje> getAllBroodjes();
    public Broodje updateBroodje(EntryBroodje entryData, long id);
    public void deleteBroodje(long id);
}
