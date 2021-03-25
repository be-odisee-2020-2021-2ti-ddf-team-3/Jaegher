package be.odisee.ti2.se4.jaegher;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class JaegherApplicationInitDB implements CommandLineRunner {

    //initialized de aangemaakte klasse in de database
    @Autowired
    KlantRepository klantRepository;

    //Dit stelt enkele initiele waarden in voor de DB
    @Override
    public void run(String... args) throws Exception {

        /*
        List<Klant> klanten = Arrays.asList(
                new Klant("Bart", "meeremans"),
                new Klant("Sander", "Deneyer"),
                new Klant("Bram", "Van Pevenage"),
                new Klant("Yarne", "Valck"),
                new Klant("Matthieu", "Waal"),
                new Klant("Brent", "IDK")
        );

        for (Klant klant : klanten) {
            klantRepository.save(klant);
        }

         */

    }
}
