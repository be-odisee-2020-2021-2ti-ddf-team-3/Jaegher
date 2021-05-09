package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PROBLEEMOPLOSSER")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Probleemoplosser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    private final String voornaam;

    private final String achternaam;

    private final String email;

    private final String telefoonnummer;
}

