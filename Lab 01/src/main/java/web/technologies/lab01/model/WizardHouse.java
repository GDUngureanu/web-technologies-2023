package web.technologies.lab01.model;

public enum WizardHouse {

    GRYFFINDOR("Gryffindor", "Bravery, courage, and chivalry"),
    HUFFLEPUFF("Hufflepuff", "Hard work, patience, loyalty, and fair play"),
    RAVENCLAW("Ravenclaw", "Intelligence, knowledge, and wit"),
    SLYTHERIN("Slytherin", "Ambition, cunning, and resourcefulness"),
    UNKNOWN("Unknown", "Unknown or not sorted into a house");

    private final String name;
    private final String traits;

    WizardHouse(String name, String traits) {
        this.name = name;
        this.traits = traits;
    }

    public String getName() {
        return name;
    }

    public String getTraits() {
        return traits;
    }
}
