package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    private final String naam;

    private final Double prijs;

    private final Double gewicht;

    private final Integer stock;
}
