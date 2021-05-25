package be.odisee.producten.dataKlassen;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class EntryProduct {
    private long id = 0;

    @NotEmpty(message="naam van het product is verplicht")
    private String naam;

    private String beschrijving;

    @Min(value = 0, message = "Een prijs moet groter dan of gelijk aan 0 zijn")
    private Double prijs;

    private String fotolink;

    @Min(value = 0, message="het product heeft een categorie nodig")
    private long categoryId;
}
