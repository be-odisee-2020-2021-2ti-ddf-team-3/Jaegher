package be.odisee.producten.dataKlassen;

import be.odisee.producten.domain.BestellingLijn;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class BestellingModel {
    public long id;

    public String naam;

    @OneToMany(mappedBy = "bestelling")
    public List<BestellingLijn> lijnen;

    public BestellingModel(long id, String naam, List<BestellingLijn> lijnen) {
        this.id = id;
        this.naam = naam;
        this.lijnen = lijnen;
    }
}
