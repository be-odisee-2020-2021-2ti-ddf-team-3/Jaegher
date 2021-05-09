package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "UURROOSTER")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Uurrooster {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @ManyToOne
    private Chauffeur chauffeur;

    private Date datum;

    private Time beginuur;

    private Time einduur;

    private Boolean aanwezig;
}
