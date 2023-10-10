package web.technologies.lab01.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import web.technologies.lab01.entity.WandEntry;
import web.technologies.lab01.model.Wand;

@Mapper
public interface WandDecipher {

    List<Wand> toWand(List<WandEntry> entities);

    @Mapping(target = "owner", source = "entry.wizard.name")
    Wand toWand(WandEntry entry);

}
