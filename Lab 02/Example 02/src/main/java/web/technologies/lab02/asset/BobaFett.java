package web.technologies.lab02.asset;

public class BobaFett {

    private final String cloneCode;
    private final String primaryWeapon;
    private final String currentBountyTarget;
    private final int bountyCollected;

    public BobaFett(String cloneCode, String primaryWeapon, String currentBountyTarget, int bountyCollected) {
        this.cloneCode = cloneCode;
        this.primaryWeapon = primaryWeapon;
        this.currentBountyTarget = currentBountyTarget;
        this.bountyCollected = bountyCollected;
    }

    public String hunt() {
        return "Boba Fett " + cloneCode + ", armed with a " + primaryWeapon + ", is on the hunt for " + currentBountyTarget + "!";
    }

}
