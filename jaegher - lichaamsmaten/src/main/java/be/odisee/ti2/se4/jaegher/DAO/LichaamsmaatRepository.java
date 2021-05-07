package be.odisee.ti2.se4.jaegher.DAO;

import be.odisee.ti2.se4.jaegher.domain.Klant;
import be.odisee.ti2.se4.jaegher.domain.Lichaamsmaat;
import org.springframework.data.repository.CrudRepository;

public interface LichaamsmaatRepository extends CrudRepository<Lichaamsmaat, Long> {
    public Lichaamsmaat findById(long id);
}
