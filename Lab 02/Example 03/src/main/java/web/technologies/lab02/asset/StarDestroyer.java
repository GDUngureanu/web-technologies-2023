package web.technologies.lab02.asset;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StarDestroyer implements Asset {

    private final String identifier;
    private final String captain;
    private final String fleet;
    private final int tieFighterCount;
    private final String status;

    public String takeAction() {
        return "Star Destroyer " + identifier + " from the " + fleet + " fleet, commanded by " + captain + " with " + tieFighterCount
            + " TIE Fighters, is deploying!";
    }

}
