package be.odisee.producten.service;

import be.odisee.producten.dataKlassen.EntryProduct;
import be.odisee.producten.domain.Product;

import java.util.List;

public interface ProductService {
    public Product addBroodje(EntryProduct entryData);
    public List<Product> getAllBroodjes();
    public Product updateBroodje(EntryProduct entryData, long id);
    public void deleteBroodje(long id);
}
