package be.odisee.broodjes.service;

import be.odisee.broodjes.dataKlassen.EntryBroodje;
import be.odisee.broodjes.domain.Broodje;

import java.util.List;

public interface BroodjeService {
    public void addTest();
    public Broodje addBroodje(EntryBroodje entryData);
    public List<Broodje> getAllBroodjes();
    public Broodje updateBroodje(EntryBroodje entryData, long id);
    public void deleteBroodje(long id);
    public void updateStatus(long id);
}
