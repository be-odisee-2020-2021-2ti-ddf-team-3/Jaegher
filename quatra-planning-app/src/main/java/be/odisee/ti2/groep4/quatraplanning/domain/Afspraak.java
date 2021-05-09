package be.odisee.ti2.groep4.quatraplanning.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "AFSPRAKEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC,force=true)
public class Afspraak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @ManyToOne
    private final Klant klant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planning_id")
    protected Planning planning;

    @OneToOne(optional = true)
    private Probleem probleem;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private final Date gewensteDatum;

    private ToestandAfspraak toestand = ToestandAfspraak.AANGEMAAKT;

    /*@OneToMany(fetch=FetchType.EAGER,mappedBy="afspraak")
    private Set<Productkeuze> m_Productkeuzes= new HashSet<Productkeuze>();*/
  
    /* Methode demo sequentie opdracht 1 (nutteloos)
    public void selecteerGewensteDatum(){
        Scanner selectieDatum = new Scanner(System.in);
        System.out.println("Geef gewenste datum");
        gewensteDatum = selectieDatum.nextLine();
        System.out.println("De gewenste datum is dus " + gewensteDatum);
        status = "aangemaakt met datum";
    }


    // Methode demo sequentie opdracht 1 (nutteloos)
    public void stuurDoorNaarPlanner(){
        if (status == "aangemaakt met datum" ){
            status = "aangevraagd";
        } else{
            System.out.println("Kan niet doorgestuurd worden.");
        }
        System.out.println("De status van uw afspraak is " +status);
    }
    */
}
