package web.technologies.lab01.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.technologies.lab01.entity.WandEntry;

@Repository
public interface OllivandersWandShop extends JpaRepository<WandEntry, UUID> {

}
