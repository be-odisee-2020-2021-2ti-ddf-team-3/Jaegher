package be.odisee.producten.dataKlassen;

import be.odisee.producten.domain.Bestelling;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

public class BestellingLijnModel {
    public long id;

    @NotEmpty(message="naam van het product is verplicht")
    public String naam;
}
