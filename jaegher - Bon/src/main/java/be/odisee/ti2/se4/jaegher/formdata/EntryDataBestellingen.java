package be.odisee.ti2.se4.jaegher.formdata;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class EntryDataBestellingen {

    private long id = 0;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String Datum;

    private String Code;


}
