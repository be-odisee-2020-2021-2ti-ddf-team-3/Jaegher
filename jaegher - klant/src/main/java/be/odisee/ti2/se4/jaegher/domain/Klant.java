package be.odisee.ti2.se4.jaegher.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//Deze klasse steld een entity voor in de DB de variabelen zijn tabelen
@Entity
@Table(name = "KLANTEN")
@XmlRootElement(name = "klant")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
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

    @NotEmpty(message="email verplicht")
    @Email(message="Vul een geldig e-mail adres in ")
    @XmlElement(name="email")
    private String email;

    @NotEmpty(message="geboortedatum verplicht")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @XmlElement(name="geboortedatum")
    private String geboortedatum;

    @NotBlank(message="address verplicht")
    @XmlElement(name="addres")
    private String addres;


}



