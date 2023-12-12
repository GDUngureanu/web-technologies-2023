package web.technologies.lab10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.technologies.lab10.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
