package web.technologies.lab01.model;

public enum WizardRole {

    STUDENT("Student", "Learns magic at Hogwarts or another magical school"),
    TEACHER("Teacher", "Teaches students at a magical school"),
    AUROR("Auror", "Dark-wizard catcher working for the Ministry of Magic"),
    MINISTRY_OFFICIAL("Ministry Official", "Works in various departments of the Ministry of Magic"),
    HEALER("Healer", "Medical professional at St. Mungo's Hospital for Magical Maladies and Injuries"),
    SHOPKEEPER("Shopkeeper", "Owns or works in a shop in places like Diagon Alley or Hogsmeade"),
    QUIDDITCH_PLAYER("Quidditch Player", "Plays Quidditch, a magical sport, professionally or for fun"),
    WRITER("Writer", "Authors books, articles, or writes for newspapers like The Daily Prophet"),
    UNSPEAKABLE("Unspeakable", "Works in the Department of Mysteries"),
    DRAGON_TAMER("Dragon Tamer", "Works with dragons in reserves or for other purposes"),
    UNKNOWN("Unknown", "Undefined role or occupation in the wizarding world");

    private final String name;
    private final String description;

    WizardRole(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
