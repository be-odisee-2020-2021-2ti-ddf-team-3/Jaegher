package be.odisee.ti2.groep4.quatraplanning.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productkeuze2")
public class Ophaling { //implements Productkeuze

    private String keuze = null;

    @Autowired
    public Ophaling(String ophalingKeuze) { this.keuze = ophalingKeuze; }

    public String getProductkeuze() {
        return keuze;
    }

    public void setProductkeuze(String keuze) {
        this.keuze = keuze;
    }

}
