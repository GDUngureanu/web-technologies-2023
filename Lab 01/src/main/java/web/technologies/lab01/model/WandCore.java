package web.technologies.lab01.model;

public enum WandCore {

    PHOENIX_FEATHER("Phoenix Feather"),
    DRAGON_HEARTSTRING("Dragon Heartstring"),
    UNICORN_HAIR("Unicorn Hair");

    private final String description;

    WandCore(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
