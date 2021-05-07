package be.odisee.ti2.se4.jaegher.DAO;

import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.domain.Ontwerp;
import org.springframework.data.repository.CrudRepository;

public interface OntwerpRepository extends CrudRepository<Ontwerp, Long> {
}
