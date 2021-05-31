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

    public BestellingLijnModel(long id, String product_naam, double product_prijs, int aantal, String commentaar, int productId) {
        this.id = id;
        this.product_naam = product_naam;
        this.product_prijs = product_prijs;
        this.aantal = aantal;
        this.commentaar = commentaar;
        this.productId = productId;
    }
}
