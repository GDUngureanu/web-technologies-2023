package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

@Service
public class GalacticPatrol extends AssetDeployment {

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
        actionLogger.log(devastator.deploy());
        actionLogger.log(tieAlpha.fly());
        actionLogger.log(trooperAlpha.patrol());

        actionLogger.log("Galactic patrol has been successfully commenced!");
        actionLogger.log("");
    }

}
