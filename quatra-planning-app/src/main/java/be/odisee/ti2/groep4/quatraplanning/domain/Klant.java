package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "KLANTEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Klant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @Column
    private final String naam;

    @Column
    private final String bedrijfsNaam;

    @Column
    private final String adres;

    @Column
    private final String email;

    @Column
    private final String telefoonnummer;
}
