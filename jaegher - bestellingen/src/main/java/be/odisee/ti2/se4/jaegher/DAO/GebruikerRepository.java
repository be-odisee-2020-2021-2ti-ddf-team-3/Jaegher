package be.odisee.ti2.se4.jaegher.DAO;

import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import org.springframework.data.repository.CrudRepository;

public interface GebruikerRepository extends CrudRepository<Gebruiker, Long> {

    public Gebruiker findByUsername(String username);
}
