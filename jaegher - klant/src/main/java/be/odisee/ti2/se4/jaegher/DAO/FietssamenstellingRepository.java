package be.odisee.ti2.se4.jaegher.DAO;

import be.odisee.ti2.se4.jaegher.domain.Fietssamenstelling;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import org.springframework.data.repository.CrudRepository;

public interface FietssamenstellingRepository extends CrudRepository<Fietssamenstelling, Long> {
}
