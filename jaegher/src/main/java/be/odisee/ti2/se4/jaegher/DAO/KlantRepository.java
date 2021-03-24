package be.odisee.ti2.se4.jaegher.DAO;

import be.odisee.ti2.se4.jaegher.domain.Klant;
import org.springframework.data.repository.CrudRepository;


//Repository die met de database spreekt heeft al crud operaties door JPA dingen zoals getbyid kunnen hier in komen
public interface KlantRepository extends CrudRepository<Klant, Long> {
}
