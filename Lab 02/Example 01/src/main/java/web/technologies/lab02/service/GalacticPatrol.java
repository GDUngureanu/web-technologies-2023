package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

public class GalacticPatrol implements AssetDeployment {

    @Autowired
    @Qualifier("devastator")
    private StarDestroyer devastator;

    @Autowired
    @Qualifier("tieAlpha")
    private TIEFighter tieAlpha;

    @Autowired
    @Qualifier("trooperAlpha")
    private Stormtrooper trooperAlpha;

    public void deployAssets() {
        devastator.deploy();
        tieAlpha.fly();
        trooperAlpha.patrol();

        System.out.println("Galactic patrol has been successfully commenced!");
    }

}
