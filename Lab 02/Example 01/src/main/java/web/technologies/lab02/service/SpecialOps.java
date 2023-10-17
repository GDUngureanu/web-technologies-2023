package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;

public class SpecialOps implements AssetDeployment {

    @Autowired
    @Qualifier("executor")
    private StarDestroyer executor;

    @Autowired
    @Qualifier("bobaOriginal")
    private BobaFett bobaOriginal;

    public void deployAssets() {
        executor.deploy();
        bobaOriginal.hunt();

        System.out.println("Special operations are now in progress!");
    }

}
