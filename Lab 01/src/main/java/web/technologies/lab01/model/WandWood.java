package web.technologies.lab01.model;

public enum WandWood {

    OAK("Oak"),
    YEW("Yew"),
    VINE("Vine"),
    WILLOW("Willow"),
    HAWTHORN("Hawthorn"),
    HOLLY("Holly");

    private final String description;

    WandWood(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
