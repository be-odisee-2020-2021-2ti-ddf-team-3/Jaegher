package be.odisee.ti2.se4.jaegher.formdata;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class EntryDataBestellingen {

    private long id = 0;

    private long klantId;
    private long klantId2;
    private long bestellingId;

    private String VoorNaam;

    private String AchterNaam;

    private String naam;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String aanMaakDatum;

    private Boolean goedgekeurd;

}
