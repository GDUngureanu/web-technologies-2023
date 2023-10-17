package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

@Service
public class UnifiedAsset extends AssetDeployment {

    private final StarDestroyer starDestroyer;
    private final TIEFighter tieFighter;
    private final Stormtrooper stormtrooper;
    private final BobaFett bobaFett;

    public UnifiedAsset(@Qualifier("interceptor") StarDestroyer starDestroyer, @Qualifier("tieZeta") TIEFighter tieFighter,
        @Qualifier("trooperZulu") Stormtrooper stormtrooper, @Qualifier("bobaClone") BobaFett bobaFett) {
        this.starDestroyer = starDestroyer;
        this.tieFighter = tieFighter;
        this.stormtrooper = stormtrooper;
        this.bobaFett = bobaFett;
    }

    @Override
    public void deployAssets() {
        actionLogger.log(starDestroyer.deploy());
        actionLogger.log(tieFighter.fly());
        actionLogger.log(stormtrooper.patrol());
        actionLogger.log(bobaFett.hunt());

        actionLogger.log("All assets have been successfully deployed!");
        actionLogger.log("");
    }

}
