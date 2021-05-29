package be.odisee.producten.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BESTELLINGEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Bestelling {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long id;

    private double totale_prijs;

    private long klant_nummer;

    private String bestelling_status;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private String besteltijd;



    //@OneToMany(mappedBy = "bestelling")
    //private List<BestellingLijn> lijnen;

    public Bestelling(long id, double totale_prijs, long klant_nummer, String bestelling_status, String besteltijd) {
        this.id = id;
        this.totale_prijs = totale_prijs;
        this.klant_nummer = klant_nummer;
        this.bestelling_status = bestelling_status;
        this.besteltijd = besteltijd;
    }
}
