package be.odisee.ti2.se4.jaegher.formdata;

import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Data
public class EntryData {

    private long id = 0;


    @NotBlank(message="verplichte voornaam")
    private String naam;

    @NotBlank(message="achternaam verplicht")
    private String achternaam;

    @NotBlank(message="geboortedatum verplicht")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String geboortedatum;

    private String addres;

    private Lichaamsmaat lichaamsmaat;

    @Email(message="Vul een geldig e-mail adres in ")
    private String email;

    private Double linkerBeen;

    private Double rechterBeen;

    private Double bekkenkanteling;

    private Double gewicht;

    @Max(value = 220, message = "Maximum groote is 220cm")
    private Double groote;

    private Double linkerArm;

    private Double rechterArm;
}
