package web.technologies.lab08.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.technologies.lab08.entity.UserEntity;
import web.technologies.lab08.model.User;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    
    List<UserEntity> findAllByNameStartsWith(String name);
    
    @Query(value = "select u from UserEntity u where upper(u.name) like upper(concat('%',:name,'%'))")
    List<UserEntity> findAllByUserName2(String name);
    
    @Query(value = "select * from USER_ENTITY u where upper(u.name) like upper(concat('%',:name,'%'))"
        , nativeQuery = true)
    List<UserEntity> findAllByUserName(String name);
    
}
