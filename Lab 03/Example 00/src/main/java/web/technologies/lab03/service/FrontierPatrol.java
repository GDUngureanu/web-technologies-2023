package web.technologies.lab03.service;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.technologies.lab03.asset.Asset;
import web.technologies.lab03.asset.BobaFett;
import web.technologies.lab03.asset.StarDestroyer;
import web.technologies.lab03.asset.TIEFighter;

@Getter
@NoArgsConstructor
public class FrontierPatrol implements AssetDeployment {

    private StarDestroyer executor;
    private TIEFighter tieCharlie;
    private BobaFett bobaOriginal;
    private BobaFett bobaClone;

    private List<Asset> assets;

    public void assignAssets() {
        this.assets = Arrays.asList(executor, tieCharlie, bobaOriginal, bobaClone);
    }

    public String deploymentShout() {
        return "Defense operations are now active!";
    }

    public void setExecutor(StarDestroyer executor) {
        this.executor = executor;
    }

    public void setTieCharlie(TIEFighter tieCharlie) {
        this.tieCharlie = tieCharlie;
    }

    public void setBobaOriginal(BobaFett bobaOriginal) {
        this.bobaOriginal = bobaOriginal;
    }

    public void setBobaClone(BobaFett bobaClone) {
        this.bobaClone = bobaClone;
    }
}