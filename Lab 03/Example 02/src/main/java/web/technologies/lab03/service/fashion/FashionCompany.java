package web.technologies.lab03.service.fashion;

import static java.util.Objects.nonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.technologies.lab03.model.fashion.Design;

@Service
@RequiredArgsConstructor
public class FashionCompany {

    private final Map<UUID, Design> designs = new HashMap<>();

    private final Designer designer;

    public Design createDesign(final String type, final String designDetails) {
        Design concept = designer.sketch(type, designDetails);

        designs.put(concept.getPatent(), concept);

        return concept;
    }

    public Design getDesign(final UUID id) {
        return designs.get(id);
    }

    public Design updateDesign(final UUID id, final String newDetails) {
        Design concept = designs.get(id);

        if (nonNull(concept)) {
            concept.setConcept(newDetails);
        }

        return concept;
    }

    public Design scrapDesign(final UUID id) {
        return designs.remove(id);
    }

    public Map<UUID, Design> getAllDesigns() {
        return designs;
    }

}
