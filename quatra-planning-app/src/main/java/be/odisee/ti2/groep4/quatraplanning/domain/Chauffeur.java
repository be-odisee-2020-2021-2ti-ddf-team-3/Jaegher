package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CHAUFFEUR")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Chauffeur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @OneToOne
    private final Vrachtwagen vrachtwagen;

    private final String voornaam;

    private final String achternaam;

    private String naam;

    private final String rijbewijs;

    private final String telefoonnummer;

    public String getNaam() {
        return voornaam + " " + achternaam;
    }
}
