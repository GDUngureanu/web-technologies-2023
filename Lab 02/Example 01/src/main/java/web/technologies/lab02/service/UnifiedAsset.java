package web.technologies.lab02.service;

import org.springframework.stereotype.Service;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

@Service
public class UnifiedAsset implements AssetDeployment {

    private final StarDestroyer starDestroyer;
    private final TIEFighter tieFighter;
    private final Stormtrooper stormtrooper;
    private final BobaFett bobaFett;

    public UnifiedAsset(StarDestroyer starDestroyer, TIEFighter tieFighter, Stormtrooper stormtrooper, BobaFett bobaFett) {
        this.starDestroyer = starDestroyer;
        this.tieFighter = tieFighter;
        this.stormtrooper = stormtrooper;
        this.bobaFett = bobaFett;
    }

    @Override
    public void deployAssets() {
        starDestroyer.deploy();
        tieFighter.fly();
        stormtrooper.patrol();
        bobaFett.hunt();

        System.out.println("All assets have been successfully deployed!");
    }

}
