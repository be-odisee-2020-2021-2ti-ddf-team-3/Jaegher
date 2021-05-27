package be.odisee.producten.DAO;

import be.odisee.producten.domain.BestellingLijn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BestellingLijnRepository extends JpaRepository<BestellingLijn, Long> {
    public BestellingLijn findById(long id);
    List<BestellingLijn> findAllByBestelling_Id(long id);
}
