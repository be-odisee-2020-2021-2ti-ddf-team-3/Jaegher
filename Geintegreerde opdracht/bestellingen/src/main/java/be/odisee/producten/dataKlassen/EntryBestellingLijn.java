package be.odisee.producten.dataKlassen;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class EntryBestellingLijn {
    private long id;

    private String product_naam;

    private double product_prijs;

    private int aantal;

    private String commentaar;

    private int productId;

    private long bestellingId;
}
