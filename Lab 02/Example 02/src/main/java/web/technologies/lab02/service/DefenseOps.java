package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

@Service
public class DefenseOps extends AssetDeployment {

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
        actionLogger.log(avenger.deploy());
        actionLogger.log(tieBravo.fly());
        actionLogger.log(trooperBravo.patrol());

        actionLogger.log("Defense operations are now active!");
        actionLogger.log("");
    }

}
