package web.technologies.lab03.config;

import web.technologies.lab03.asset.BobaFett;
import web.technologies.lab03.asset.StarDestroyer;
import web.technologies.lab03.asset.TIEFighter;

public class EmpireConfiguration {

    public StarDestroyer devastator() {
        return new StarDestroyer("Devastator", "Darth Vader", "Death Squadron", 72, "Active");
    }

    public StarDestroyer executor() {
        return new StarDestroyer("Executor", "Firmus Piett", "Executor Fleet", 144, "Active");
    }

    public TIEFighter tieAlpha() {
        return new TIEFighter("ALPHA-001", "Mauler Mithel", 2, "Active", 50);
    }

    public TIEFighter tieBravo() {
        return new TIEFighter("BRAVO-002", "Backstabber", 2, "Active", 40);
    }

    public TIEFighter tieCharlie() {
        return new TIEFighter("CHARLIE-003", "Dark Curse", 2, "Damaged", 60);
    }

    public BobaFett bobaOriginal() {
        return new BobaFett("BF-Original", "EE-3 Carbine Rifle", "Han Solo", 10000);
    }

    public BobaFett bobaClone() {
        return new BobaFett("BF-Clone", "Vibroblade", "Cad Bane", 12000);
    }

}
