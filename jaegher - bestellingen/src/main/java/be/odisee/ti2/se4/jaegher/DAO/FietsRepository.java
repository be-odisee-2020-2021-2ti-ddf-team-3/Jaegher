package be.odisee.ti2.se4.jaegher.DAO;

import be.odisee.ti2.se4.jaegher.domain.Fiets;
import be.odisee.ti2.se4.jaegher.domain.Klant;
import org.springframework.data.repository.CrudRepository;

public interface FietsRepository extends CrudRepository<Fiets, Long> {
}
