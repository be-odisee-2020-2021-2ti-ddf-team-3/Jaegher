package be.odisee.broodjes.DAO;

import be.odisee.broodjes.domain.Broodje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BroodjeRepository extends JpaRepository<Broodje, Long> {
    public Broodje findById(long id);
}
