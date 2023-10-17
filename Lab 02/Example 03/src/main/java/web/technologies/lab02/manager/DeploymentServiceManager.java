package web.technologies.lab02.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab02.logger.ActionLogger;
import web.technologies.lab02.service.AssetDeployment;

@Service
public class DeploymentServiceManager {

    private static final String DEPLOYMENT_FINISHED = "";

    @Autowired
    private ActionLogger actionLogger;

    public void triggerDeployment(AssetDeployment assetDeployment) {
        for (final var asset : assetDeployment.getAssets()) {
            actionLogger.log(asset.takeAction());
        }

        actionLogger.log(assetDeployment.deploymentShout());
        actionLogger.log(DEPLOYMENT_FINISHED);
    }

}
