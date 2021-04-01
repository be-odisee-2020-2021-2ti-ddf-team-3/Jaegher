package be.odisee.ti2.se4.jaegher.formdata;

import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class EntryData {

    private long id = 0;

    private String naam;

    private String achternaam;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String geboortedatum;

    private String addres;

    private Lichaamsmaat lichaamsmaat;

    private String email;

    private Double linkerBeen;

    private Double rechterBeen;

    private Double bekkenkanteling;

    private Double gewicht;

    private Double groote;

    private Double linkerArm;

    private Double rechterArm;
}
