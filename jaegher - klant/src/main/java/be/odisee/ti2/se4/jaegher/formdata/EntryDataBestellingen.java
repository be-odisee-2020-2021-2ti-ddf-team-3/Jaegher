package be.odisee.ti2.se4.jaegher.formdata;

import be.odisee.ti2.se4.jaegher.domain.Klant;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class EntryDataBestellingen {

    private long id = 0;

    private long klantId;
    private long bestellingId;

    private String VoorNaam;

    private String AchterNaam;

    private String naam;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String aanMaakDatum;

    private Boolean goedgekeurd;

}
