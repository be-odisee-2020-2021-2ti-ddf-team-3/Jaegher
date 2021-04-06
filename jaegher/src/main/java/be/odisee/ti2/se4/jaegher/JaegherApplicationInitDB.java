package be.odisee.ti2.se4.jaegher;

import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class JaegherApplicationInitDB implements CommandLineRunner {

    //initialized de aangemaakte klasse in de database
    @Autowired
    KlantRepository klantRepository;
    @Autowired
    GebruikerRepository gebruikerRepository;


    //Dit stelt enkele initiele waarden in voor de DB
    @Override
    public void run(String... args) throws Exception {

        List<Gebruiker> users = Arrays.asList(
                new Gebruiker(1, "imke",
                        "imkeww",
                        "KLANT"),
                new Gebruiker(2,"tessa",
                        "tessaww",
                        "KLANT"),
                new Gebruiker(3, "nicky",
                        "nickyww",
                        "BIKEFITTER"),
                new Gebruiker(4, "hans",
                        "hansww",
                        "BIKEFITTER")
        );

        for (Gebruiker gebruiker : users) {
            gebruikerRepository.save(gebruiker);
        };

    }
}
