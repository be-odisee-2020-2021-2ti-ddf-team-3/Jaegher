package be.odisee.producten.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "BESTELLIJNEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class BestellingLijn {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long id;

    @NotEmpty(message="naam van het product is verplicht")
    private String product_naam;

    private double product_prijs;

    private int aantal;

    private String commentaar;

    @ManyToOne
    @JoinColumn(name="bestelling_id")
    private Bestelling bestelling;

}
