package be.odisee.producten.DAO;

import be.odisee.producten.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductenRepository extends JpaRepository<Product, Long> {
    public Product findById(long id);
    List<Product> findAllByCategorie_Id(long id);
}
