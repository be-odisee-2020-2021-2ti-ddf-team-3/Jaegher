package be.odisee.ti2.se4.jaegher.formdata;

import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import lombok.Data;

@Data
public class EntryData {

    private long id = 0;

    private String naam;

    private String achternaam;

    private Lichaamsmaat lichaamsmaat;

    private String email;

    private Double linkerBeen;

    private Double rechterBeen;
}
