package web.technologies.lab01.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab01.model.Wizard;
import web.technologies.lab01.model.WizardHouse;
import web.technologies.lab01.service.WizardryService;

@RestController
@RequestMapping("/api/wizards")
public class WizardryController {

    @Autowired
    private WizardryService wizardryService;

    @PostMapping("/enlist")
    public ResponseEntity<Wizard> enlistWizard(@RequestBody Wizard wizardApplicant) {
        final var newWizard = wizardryService.enlistNewWizard(wizardApplicant);

        return new ResponseEntity<>(newWizard, HttpStatus.CREATED);
    }

    @GetMapping("/summon/{id}")
    public ResponseEntity<Wizard> summonWizard(@PathVariable UUID id) {
        final var wizardDTO = wizardryService.summonWizardById(id);

        return ResponseEntity.ok(wizardDTO);
    }

    @GetMapping("/summon-all")
    public ResponseEntity<List<Wizard>> summonEntireWizardry() {
        final var allWizards = wizardryService.summonAllWizards();

        return ResponseEntity.ok(allWizards);
    }

    @GetMapping("/summon-from-house/{house}")
    public ResponseEntity<List<Wizard>> checkCompartmentsForHouse(@PathVariable WizardHouse house) {
        final var students = wizardryService.summonYoungWizardsFrom(house);

        return ResponseEntity.ok(students);
    }

}
