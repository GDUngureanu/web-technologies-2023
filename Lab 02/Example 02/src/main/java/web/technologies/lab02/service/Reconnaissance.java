package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

@Service
public class Reconnaissance extends AssetDeployment {

    @Autowired
    @Qualifier("tieEcho")
    private TIEFighter tieEcho;

    @Autowired
    @Qualifier("trooperEcho")
    private Stormtrooper trooperEcho;

    public void deployAssets() {
        actionLogger.log(tieEcho.fly());
        actionLogger.log(trooperEcho.patrol());

        actionLogger.log("Reconnaissance mission is underway!");
        actionLogger.log("");
    }

}
