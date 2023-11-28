package web.technologies.lab07.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.technologies.lab07.entity.UserEntity;
import web.technologies.lab07.model.User;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    
    Optional<UserEntity> findUserEntityByEmailIgnoreCase(final String email);
    
    Optional<UserEntity> findUserEntityByEmailIgnoreCaseAndPassword(final String email, final String password);

}
