package web.technologies.lab07.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.technologies.lab07.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
