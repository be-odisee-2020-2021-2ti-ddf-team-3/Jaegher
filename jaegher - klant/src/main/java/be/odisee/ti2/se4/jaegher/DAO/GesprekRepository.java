package be.odisee.ti2.se4.jaegher.DAO;

import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.domain.Gesprek;
import org.springframework.data.repository.CrudRepository;

public interface GesprekRepository extends CrudRepository<Gesprek, Long> {
}
