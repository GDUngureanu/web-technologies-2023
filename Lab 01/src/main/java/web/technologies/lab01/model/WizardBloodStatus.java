package web.technologies.lab01.model;

public enum WizardBloodStatus {
    PURE_BLOOD("Pure-blood"),
    HALF_BLOOD("Half-blood"),
    MUGGLE_BORN("Muggle-born"),
    SQUIB("Squib"),
    UNKNOWN("Unknown");

    private final String description;

    WizardBloodStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
