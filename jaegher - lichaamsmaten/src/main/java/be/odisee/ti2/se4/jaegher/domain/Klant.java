package be.odisee.ti2.se4.jaegher.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlElement;


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
    @XmlElement(name="naam")
    private String naam;

    @NotEmpty(message="achternaam verplicht")
    @Size(min = 2, message = "Minimum 2 letters")
    @XmlElement(name="achternaam")
    private String achternaam;

    @OneToOne(cascade = {CascadeType.ALL})
    @JsonBackReference
    @XmlElement(name="lichaamsmaat")
    private Lichaamsmaat lichaamsmaat;

    @Email(message="Vul een geldig e-mail adres in ")
    @XmlElement(name="email")
    private String email;

    @NotEmpty(message="geboortedatum verplicht")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @XmlElement(name="geboortedatum")
    private String geboortedatum;

    @XmlElement(name="addres")
    private String addres;


}



