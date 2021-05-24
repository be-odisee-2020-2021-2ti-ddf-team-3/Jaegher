package be.odisee.broodjes.DAO;

import be.odisee.broodjes.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
