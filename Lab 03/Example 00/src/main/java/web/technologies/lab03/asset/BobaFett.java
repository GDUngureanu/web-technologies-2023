package web.technologies.lab03.asset;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class BobaFett implements Asset {

    private final String cloneCode;
    private final String primaryWeapon;
    private final String currentBountyTarget;
    private final int bountyCollected;

    @Override
    public String takeAction() {
        return "Boba Fett " + cloneCode + ", armed with a " + primaryWeapon + ", is on the hunt for " + currentBountyTarget + "!";
    }

}
