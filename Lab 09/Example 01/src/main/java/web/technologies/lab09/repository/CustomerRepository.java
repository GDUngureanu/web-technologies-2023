package web.technologies.lab09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.technologies.lab09.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
