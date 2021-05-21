package be.odisee.broodjes.DAO;

import be.odisee.broodjes.domain.Broodje;
import org.springframework.data.repository.CrudRepository;

public interface BroodjeRepository extends CrudRepository<Broodje, Long> {
    public Broodje findById(long id);
}
