package be.odisee.ti2.groep4.quatraplanning.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PLANNINGS")
@XmlRootElement(name = "planning")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force=true)
public class Planning {

    @ManyToOne
    private User user;

    /**
     * Automatisch gegenereerd id.
     * Niet-optioneel
     * Niet-wijzigbaar
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Manueel toegewezen chauffeur.
     * Optioneel
     * Wijzigbaar (manueel)
     */
    @ManyToOne
    private Chauffeur chauffeur;

    /**
     * Automatisch toegewezen planner.
     * Optioneel
     * Niet-wijzigbaar
     */
    @ManyToOne
    @Getter
    @NonNull
    private Planner planner;

    /**
     * Manueel toegewezen datum.
     * Niet-optioneel
     * Niet-wijzigbaar
     */
    //TODO: type zetten op Date
    //TODO: terug final maken (mag niet veranderen). opletten, datum final zetten veroorzaakt een probleem waarbij de formPlanning props niet gewijzigd kunnen worden en dus als null worden doorgegeven bij createPlanning
    @NotNull(message = "Datum niet leeg")
    @Getter
    @NonNull
    private Date datum;

    /**
     * Automatisch toegewezen toestand.
     * Niet-optioneel
     * Wijzigbaar (automatisch)
     * Standaardwaarde: AANGEMAAKT
     */
    @Column
    private ToestandPlanning toestand = ToestandPlanning.AANGEMAAKT;

    /**
     * Manueel toegewezen afspraken.
     * Optioneel
     * Wijzigbaar (manueel)
     */
    @Column
    @OneToMany(mappedBy = "planning", cascade = CascadeType.ALL)
    private List<Afspraak> m_Afspraken = new ArrayList<Afspraak>();

    /************
     * METHODES *
     ************/

    public void voegAfspraakToe(Afspraak newAfspraak) {
        m_Afspraken.add(newAfspraak);
        newAfspraak.setPlanning(this);
    }

    public void haalAfspraakWeg(Afspraak oldAfspraak) {
        m_Afspraken.remove(oldAfspraak);
        oldAfspraak.setPlanning(null);
    }

    @XmlElement(name = "id")
    public long getId() {return id;}

    @XmlElement(name = "chauffeur")
    public Chauffeur getChauffeur() {return chauffeur;}

    @XmlElement(name = "planner")
    public Planner getPlanner() {return planner;}

    @XmlElement(name = "datum")
    public Date getDatum() {return datum;}

    @XmlElement(name = "toestand")
    public ToestandPlanning getToestand() {return toestand;}

    @XmlElement(name = "m_Afspraken")
    public List<Afspraak> getAfspraken() {return m_Afspraken;}
}