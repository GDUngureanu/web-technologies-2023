package web.technologies.lab03.model.fashion;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter

@Component
@Scope("prototype")
@AllArgsConstructor
public class Design {

    private final UUID patent = UUID.randomUUID();
    private String type; // e.g., "Shirt", "Pants"
    private String concept; // e.g., "Plain", "Floral"

    @Override
    public String toString() {
        return "Design " + patent + " of type " + type + " with the unique \"" + concept + "\" design.";
    }
}
