package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

public class Reconnaissance implements AssetDeployment {

    @Autowired
    @Qualifier("tieEcho")
    private TIEFighter tieEcho;

    @Autowired
    @Qualifier("trooperEcho")
    private Stormtrooper trooperEcho;

    public void deployAssets() {
        tieEcho.fly();
        trooperEcho.patrol();

        System.out.println("Reconnaissance mission is underway!");
    }

}
