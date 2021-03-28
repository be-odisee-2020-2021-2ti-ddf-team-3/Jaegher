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
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Bestelling {
    @Id
    private final long id;

    @ManyToOne
    private Klant klant;

    private String aanMaakDatum;

    @OneToOne
    private Fietssamenstelling fietssamenstelling;

    @OneToOne
    private Ontwerp ontwerp;

}
