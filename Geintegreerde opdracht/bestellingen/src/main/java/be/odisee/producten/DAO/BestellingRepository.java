package be.odisee.producten.DAO;

import be.odisee.producten.domain.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellingRepository extends JpaRepository<Bestelling, Long> {
}
