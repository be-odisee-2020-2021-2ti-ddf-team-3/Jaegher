package be.odisee.producten.DAO;

import be.odisee.producten.domain.Broodje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BroodjeRepository extends JpaRepository<Broodje, Long> {
    public Broodje findById(long id);
    List<Broodje> findAllByCategory_Id(long id);
}
