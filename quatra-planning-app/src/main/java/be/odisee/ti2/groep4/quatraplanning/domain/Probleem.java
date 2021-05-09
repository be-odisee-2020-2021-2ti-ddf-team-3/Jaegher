package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "PROBLEMEN")
@XmlRootElement(name = "PROBLEEM")

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Probleem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @NonNull
    private Probleemoplosser probleemoplosser;
    @NonNull
    private String probleemstelling;

    private String oplossing;

    private String toestand;


    @XmlElement(name = "id")
    public long getId() {return id;}

    @XmlElement(name = "probleemoplosser")
    public Probleemoplosser getProbleemoplosser() {return probleemoplosser;}

    @XmlElement(name = "probleemstelling")
    public String getProbleemstelling() {return probleemstelling;}

    @XmlElement(name = "oplossing")
    public String getOplossing() {return oplossing;}

    @XmlElement(name = "toestand")
    public String getToestand() {return toestand;}

}
