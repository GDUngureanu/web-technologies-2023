package web.technologies.lab01.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import web.technologies.lab01.entity.WandEntry;
import web.technologies.lab01.entity.WizardEntry;
import web.technologies.lab01.model.Wand;
import web.technologies.lab01.model.Wizard;

@Mapper
public interface WizardryMapper {

    Wizard toWizard(WizardEntry entry);

    List<Wizard> toWizard(List<WizardEntry> entries);

    @Mapping(target = "owner", source = "entry.wizard.name")
    Wand toWand(WandEntry entry);

    WizardEntry toEntry(Wizard wizard);

    WandEntry toEntry(Wand wand);


}
