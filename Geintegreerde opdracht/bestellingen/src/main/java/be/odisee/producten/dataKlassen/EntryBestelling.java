package be.odisee.producten.dataKlassen;

import lombok.Data;

@Data
public class EntryBestelling {
    private long id;

    private double totale_prijs;

    private long klant_nummer;

    private String bestelling_status;
}
