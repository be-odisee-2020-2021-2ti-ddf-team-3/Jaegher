package be.odisee.ti2.se4.jaegher.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FIETSEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Fiets {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long id;

    private String status;
    private String naam;
    private String model;
    @ManyToOne
    private Bestelling bestelling;

    @OneToOne
    private Fietssamenstelling fietssamenstelling;

    @OneToOne
    private Ontwerp ontwerp;
}
