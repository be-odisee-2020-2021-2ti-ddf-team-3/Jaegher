package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTKEUZE")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Productkeuze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @ManyToOne
    private final Product product;

    @ManyToOne
    private final Afspraak afspraak;

    private final Integer aantal;

    private final Boolean isAnderProduct;

    private final Double gewicht;
}