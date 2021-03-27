package be.odisee.ti2.se4.jaegher.domain;

import lombok.*;

import javax.persistence.*;

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

    private String naam;

    private String achternaam;

    @OneToOne
    private Lichaamsmaat lichaamsmaat;


}



