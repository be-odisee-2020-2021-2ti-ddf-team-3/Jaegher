package be.odisee.producten.dataKlassen;

import be.odisee.producten.domain.BestellingLijn;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class BestellingModel {
    public long id;

    public double totale_prijs;

    public long klant_nummer;

    public String bestelling_status;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    public String besteltijd;


    @OneToMany(mappedBy = "bestelling")
    public List<BestellingLijn> lijnen;

    public BestellingModel(long id, double totale_prijs, long klant_nummer, String bestelling_status, String besteltijd, List<BestellingLijn> lijnen) {
        this.id = id;
        this.totale_prijs = totale_prijs;
        this.klant_nummer = klant_nummer;
        this.bestelling_status = bestelling_status;
        this.besteltijd = besteltijd;
        this.lijnen = lijnen;
    }
}
