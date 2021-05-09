package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "VRACHTWAGEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Vrachtwagen {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    private final String nummerplaat;

    private final String type;

    private final Integer laadvermogen;
}
