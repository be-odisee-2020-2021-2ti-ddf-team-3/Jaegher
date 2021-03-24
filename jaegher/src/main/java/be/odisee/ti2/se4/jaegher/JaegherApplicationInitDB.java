package be.odisee.ti2.se4.jaegher;

import be.odisee.ti2.se4.jaegher.DAO.KlantRepository;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.List;

public class JaegherApplicationInitDB implements CommandLineRunner {

    @Autowired
    KlantRepository klantRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Klant> categories = Arrays.asList(
                new Klant(1, "OVHD"),
                new Klant(2, "NETW"),
                new Klant(3, "PROSP"),
                new Klant(4, "FULF"),
                new Klant(5, "REND"),
                new Klant(6, "TRAVEL")
        );

        for (Klant category : categories) {
            klantRepository.save(category);
        }

    }
}
