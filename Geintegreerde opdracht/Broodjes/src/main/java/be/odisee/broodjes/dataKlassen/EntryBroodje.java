package be.odisee.broodjes.dataKlassen;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class EntryBroodje {
    private long id = 0;
    @NotEmpty(message="naam van het broodje is verplicht")
    private String naam;
    @NotEmpty(message="beschrijving van het broodje is verplicht")
    private String beschrijving;
    @Min(value = 0, message = "Een prijs moet groter dan of gelijk aan 0 zijn")
    private Double prijs;
}
