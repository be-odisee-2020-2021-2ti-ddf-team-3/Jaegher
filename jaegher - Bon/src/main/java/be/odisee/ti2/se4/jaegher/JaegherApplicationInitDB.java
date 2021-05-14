package be.odisee.ti2.se4.jaegher;

import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
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
    GebruikerRepository gebruikerRepository;


    //Dit stelt enkele initiele waarden in voor de DB
    @Override
    public void run(String... args) throws Exception {

        List<Gebruiker> users = Arrays.asList(
                new Gebruiker(1, "imke",
                        "{bcrypt}$2a$10$JXA4QgnyC/d5v6RT1liSl.gg0bX/GjH0y7h1mZNUndZjhjpCDtHMW", //imkeww
                        "KLANT"),
                new Gebruiker(2,"tessa",
                        "{bcrypt}$2a$10$v0AhJ0k0EFKJNsjvHDLWYu0P8hVVx7wRJRPIweQUzr8dFRALF7saC", //tessaww
                        "KLANT"),
                new Gebruiker(3, "test",
                        "{bcrypt}$2a$10$4KgVIW.3TULRU8499sny0OeqRF.SFlmbzASQZj6X/1vdw.klEZWaG", //testww
                        "BIKEFITTER"),
                new Gebruiker(4, "hans",
                "{bcrypt}$2a$10$nLBW.FxJeC8pRPw4H2vsEuB7Q4MAqdHdi9e7dLMNtgQY4oVNK2OH2", //hansww
                "BIKEFITTER"),
                new Gebruiker(5, "admin",
                        "{bcrypt}$2a$10$IBdzG00.GH5kqfYxYdDUEOqkUyHjBQyZZ1o7LFsLsP6sho7ANPtki", //adminww
                        "ADMIN")
        );

        for (Gebruiker gebruiker : users) {
            gebruikerRepository.save(gebruiker);
        };

    }
}
