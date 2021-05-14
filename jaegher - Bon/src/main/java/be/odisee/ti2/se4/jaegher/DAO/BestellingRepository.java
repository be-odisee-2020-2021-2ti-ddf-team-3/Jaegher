package be.odisee.ti2.se4.jaegher.DAO;

import be.odisee.ti2.se4.jaegher.domain.Bestelling;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BestellingRepository extends CrudRepository<Bestelling, Long> {
    public Bestelling findById(long id);

}
