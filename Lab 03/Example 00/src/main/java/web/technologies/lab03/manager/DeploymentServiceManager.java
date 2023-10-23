package web.technologies.lab03.manager;

import web.technologies.lab03.logger.ActionLogger;
import web.technologies.lab03.service.AssetDeployment;

public class DeploymentServiceManager {

    private static final String DEPLOYMENT_FINISHED = "";

    private ActionLogger actionLogger;

    public void triggerDeployment(AssetDeployment assetDeployment) {
        for (final var asset : assetDeployment.getAssets()) {
            actionLogger.log(asset.takeAction());
        }

        actionLogger.log(assetDeployment.deploymentShout());
        actionLogger.log(DEPLOYMENT_FINISHED);
    }

}
