package be.odisee.producten.service;

import be.odisee.producten.DAO.ProductenRepository;
import be.odisee.producten.DAO.CategoryRepository;
import be.odisee.producten.dataKlassen.EntryProduct;
import be.odisee.producten.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductenRepository productenRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllBroodjes() {
        return (List<Product>) productenRepository.findAll();
    }

    @Override
    public void addTest() {
        Product klant = new Product();
        klant.setNaam("Voornaam");
        productenRepository.save(klant);
    }
    @Override
    public Product addBroodje(EntryProduct entryData) {
        Product entry = new Product();

        String naam = entryData.getNaam();
        entry.setNaam(naam);
        String beschrijving = entryData.getBeschrijving();
        entry.setBeschrijving(beschrijving);
        Double prijs = entryData.getPrijs();
        entry.setPrijs(prijs);
        entry.setFotolink(entryData.getFotolink());
        entry.setCategory(categoryRepository.getById(entryData.getCategoryId()));
        productenRepository.save(entry);
        return entry;
    }


    @Override
    public Product updateBroodje(EntryProduct entryData, long id) {
        Product product = productenRepository.findById(id);
        product.setNaam(entryData.getNaam());
        product.setBeschrijving(entryData.getBeschrijving());
        product.setPrijs(entryData.getPrijs());
        product.setFotolink(entryData.getFotolink());
        product.setCategory(categoryRepository.getById(entryData.getCategoryId()));

        productenRepository.save(product);
        return product;
    }

    @Override
    public void deleteBroodje(long id){
        Product product = productenRepository.findById(id);
        productenRepository.delete(product);
    }

}