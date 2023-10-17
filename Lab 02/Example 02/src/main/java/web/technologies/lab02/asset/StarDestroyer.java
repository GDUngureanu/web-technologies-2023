package web.technologies.lab02.asset;

public class StarDestroyer {

    private final String identifier;
    private final String captain;
    private final String fleet;
    private final int tieFighterCount;
    private final String status;

    public StarDestroyer(String identifier, String captain, String fleet, int tieFighterCount, String status) {
        this.identifier = identifier;
        this.captain = captain;
        this.fleet = fleet;
        this.tieFighterCount = tieFighterCount;
        this.status = status;
    }

    public String deploy() {
        return "Star Destroyer " + identifier + " from the " + fleet + " fleet, commanded by " + captain + " with " + tieFighterCount
            + " TIE Fighters, is deploying!";
    }

}
