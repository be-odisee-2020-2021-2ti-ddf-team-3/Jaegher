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

        List<Klant> klanten = Arrays.asList(
                new Klant(1, "Bart"),
                new Klant(2, "Sander"),
                new Klant(3, "Bram"),
                new Klant(4, "Yarne"),
                new Klant(5, "Matthieu"),
                new Klant(6, "Brent")
        );

        for (Klant klant : klanten) {
            klantRepository.save(klant);
        }

    }
}
