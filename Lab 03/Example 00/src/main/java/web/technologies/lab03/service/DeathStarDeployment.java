package web.technologies.lab03.service;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import web.technologies.lab03.asset.Asset;
import web.technologies.lab03.asset.StarDestroyer;

@Getter
public class DeathStarDeployment implements AssetDeployment {

    private final List<Asset> assets;

    public DeathStarDeployment(final StarDestroyer devastator) {
        this.assets = Arrays.asList(devastator);
    }

    public String deploymentShout() {
        return "Special operations are now in progress!";
    }

}
