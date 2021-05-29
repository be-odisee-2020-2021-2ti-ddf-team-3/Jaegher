package be.odisee.producten.dataKlassen;

import be.odisee.producten.domain.Bestelling;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

public class BestellingLijnModel {
    public long id;

    public String product_naam;

    public double product_prijs;

    public int aantal;

    public String commentaar;

    public int productId;
}
