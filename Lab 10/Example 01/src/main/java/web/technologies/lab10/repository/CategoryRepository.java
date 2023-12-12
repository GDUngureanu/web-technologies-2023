package web.technologies.lab10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.technologies.lab10.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
