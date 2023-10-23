package web.technologies.lab03.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@AllArgsConstructor
public class Design {

    private final UUID patent;
    private String type; // e.g., "Shirt", "Pants"
    private String concept; // e.g., "Plain", "Floral"

    @Override
    public String toString() {
        return "Design " + patent + " of type " + type + " with the unique \"" + concept + "\" design.";
    }
}
