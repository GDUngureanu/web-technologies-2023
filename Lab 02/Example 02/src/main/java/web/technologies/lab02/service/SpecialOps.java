package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;

@Service
public class SpecialOps extends AssetDeployment {

    @Autowired
    @Qualifier("executor")
    private StarDestroyer executor;

    @Autowired
    @Qualifier("bobaOriginal")
    private BobaFett bobaOriginal;

    public void deployAssets() {
        actionLogger.log(executor.deploy());
        actionLogger.log(bobaOriginal.hunt());

        actionLogger.log("Special operations are now in progress!");
        actionLogger.log("");
    }

}
