package web.technologies.lab02.service;

import java.util.List;

import web.technologies.lab02.asset.Asset;

public interface AssetDeployment {

    List<Asset> getAssets();

    String deploymentShout();

    default void assignAssets() {
        // Do nothing.
    }

}
