package be.odisee.producten.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
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

    private String naam;

    //@OneToMany(mappedBy = "bestelling")
    //private List<BestellingLijn> lijnen;

    public Bestelling(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }
}
