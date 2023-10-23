package web.technologies.lab03.service;

import java.util.List;

import web.technologies.lab03.asset.Asset;

public interface AssetDeployment {

    List<Asset> getAssets();

    String deploymentShout();

    default void assignAssets() {
        // Do nothing.
    }

}
