package be.odisee.ti2.groep4.quatraplanning.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productkeuze1")
public class Levering { //implements Productkeuze

    private String keuze = "levering";

    public Levering() { }

    public String getProductkeuze() {
        return keuze;
    }

    @Autowired
    public void setProductkeuze(String leveringKeuze) {
        this.keuze = leveringKeuze;
    }

}
