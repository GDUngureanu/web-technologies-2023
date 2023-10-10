package web.technologies.lab01.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab01.mapper.WizardryMapper;
import web.technologies.lab01.model.Wizard;
import web.technologies.lab01.model.WizardHouse;
import web.technologies.lab01.model.WizardRole;
import web.technologies.lab01.repository.HogwartsEnrollment;

@Service
public class WizardryService {

    @Autowired
    private HogwartsEnrollment hogwartsEnrollment;

    @Autowired
    private WizardryMapper wizardryMapper;

    public Wizard enlistNewWizard(final Wizard wizardApplicant) {
        final var wizardEntry = wizardryMapper.toEntry(wizardApplicant);

        final var applicationApproved = hogwartsEnrollment.save(wizardEntry);

        return wizardryMapper.toWizard(applicationApproved);
    }

    public Wizard summonWizardById(final UUID wizardId) {
        final var wizardEntry = hogwartsEnrollment.findById(wizardId)
            .orElseThrow(() -> new RuntimeException("Wizard vanished into thin air!"));

        return wizardryMapper.toWizard(wizardEntry);
    }

    public List<Wizard> summonAllWizards() {
        final var wizardEntries = hogwartsEnrollment.findAll();

        return wizardryMapper.toWizard(wizardEntries);
    }

    public List<Wizard> summonYoungWizardsFrom(WizardHouse house) {
        final var youngWizardEntries = hogwartsEnrollment.findByHouseAndRole(house, WizardRole.STUDENT);

        return wizardryMapper.toWizard(youngWizardEntries);
    }

}
