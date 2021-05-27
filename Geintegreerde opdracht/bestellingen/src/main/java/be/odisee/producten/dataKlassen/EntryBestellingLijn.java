package be.odisee.producten.dataKlassen;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class EntryBestellingLijn {
    private long id = 0;

    private String naam;

    private long bestellingId;
}
