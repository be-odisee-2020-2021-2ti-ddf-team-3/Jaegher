package be.odisee.ti2.se4.jaegher.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;


//Deze klasse steld een entity voor in de DB de variabelen zijn tabelen
@Entity
@Table(name = "KLANTEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Klant {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final long id;

    @NotEmpty(message="verplichte voornaam")
    @Size(min = 2, message = "Minimum 2 letters")
    private String naam;

    @NotEmpty(message="achternaam verplicht")
    @Size(min = 2, message = "Minimum 2 letters")
    private String achternaam;

    @OneToOne(cascade = {CascadeType.ALL})
    private Lichaamsmaat lichaamsmaat;

    @Email(message="Vul een geldig e-mail adres in ")
    private String email;

    @NotEmpty(message="geboortedatum verplicht")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String geboortedatum;

    private String addres;


}



