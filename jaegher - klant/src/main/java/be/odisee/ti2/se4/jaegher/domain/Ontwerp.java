package be.odisee.ti2.se4.jaegher.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ONTWERPEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ontwerp {
    @Id
    private final long id;

    private String status;

    private String casetteAfstelling;

    private String frameAfstelling;

    private String pedalenAfstelling;

    private Double prijs;

    private String shifterAfstelling;

    private String zadelAfstelling;

    private String stuurAfstelling;

    private int frameFormaat;

    private Boolean goedgekeurd;

    @ManyToOne
    private Bestelling bestelling;
}
