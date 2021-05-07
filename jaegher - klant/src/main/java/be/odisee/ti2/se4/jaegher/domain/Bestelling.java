package be.odisee.ti2.se4.jaegher.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BESTELLINGEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Bestelling {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final long id;

    private String naam;

    private String aanMaakDatum;

    private Boolean goedgekeurd;

    @ManyToOne
    private Klant klant;


}
