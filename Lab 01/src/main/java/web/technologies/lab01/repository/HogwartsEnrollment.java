package web.technologies.lab01.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.technologies.lab01.entity.WizardEntry;
import web.technologies.lab01.model.WizardHouse;
import web.technologies.lab01.model.WizardRole;

@Repository
public interface HogwartsEnrollment extends JpaRepository<WizardEntry, UUID> {

    List<WizardEntry> findByHouseAndRole(WizardHouse house, WizardRole role);

}
