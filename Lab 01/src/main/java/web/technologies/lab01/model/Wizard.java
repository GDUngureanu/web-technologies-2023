package web.technologies.lab01.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wizard {

    private UUID id;

    private String name;
    private Integer age;
    //    private Date dateOfBirth;
    private WizardBloodStatus bloodStatus; // e.g., Pure-blood, Half-blood, Muggle-born

    // School-related properties
    private WizardHouse house; // e.g., Gryffindor, Hufflepuff, Ravenclaw, Slytherin
    //    private List<String> subjects; // e.g., Defense Against the Dark Arts, Potions, etc.
    //    private String patronusForm; // e.g., Stag, Otter, Jack Russell Terrier

    // Other properties
    //    private String boggartForm; // Represents the wizard's deepest fear
    private WizardRole role; // e.g., Student, Teacher, Auror, Ministry Official
    //    private String physicalDescription;

    // Wizarding abilities & possessions
    //    private boolean isAnimagus;
    //    private String animagusForm; // e.g., Dog, Cat, Stag; only applicable if isAnimagus is true
    private Wand wand; // Wand can be another class with properties like wood, core, length
    //    private List<String> knownSpells;

    // Personal attributes
    //    private List<String> friends;
    //    private List<String> enemies;
    //    private String loyalty; // e.g., Dumbledore's Army, Death Eater, Order of the Phoenix

}
