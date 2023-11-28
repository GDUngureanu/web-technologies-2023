package web.technologies.lab08.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.technologies.lab08.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {


}
