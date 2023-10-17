package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

public class DefenseOps implements AssetDeployment {

    @Autowired
    @Qualifier("avenger")
    private StarDestroyer avenger;

    @Autowired
    @Qualifier("tieBravo")
    private TIEFighter tieBravo;

    @Autowired
    @Qualifier("trooperBravo")
    private Stormtrooper trooperBravo;

    public void deployAssets() {
        avenger.deploy();
        tieBravo.fly();
        trooperBravo.patrol();

        System.out.println("Defense operations are now active!");
    }

}
