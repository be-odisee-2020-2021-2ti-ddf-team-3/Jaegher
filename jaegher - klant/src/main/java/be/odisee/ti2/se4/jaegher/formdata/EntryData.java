package be.odisee.ti2.se4.jaegher.formdata;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@Data
public class EntryData {

    private long id = 0;


    @NotBlank(message="verplichte voornaam")
    @Size(min = 2, message = "Minimum 2 letters")
    private String naam;

    @NotBlank(message="achternaam verplicht")
    @Size(min = 2, message = "Minimum 2 letters")
    private String achternaam;


    @NotBlank(message="geboortedatum verplicht")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String geboortedatum;

    @NotBlank(message="address verplicht")
    private String addres;


    @NotBlank(message="email verplicht")
    private String email;

}
