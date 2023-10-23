package web.technologies.lab03.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import web.technologies.lab03.manager.DeploymentServiceManager;
import web.technologies.lab03.service.AssetDeployment;

@Component
public class EmpireManagementInterceptor {

    @Autowired
    private DeploymentServiceManager deploymentServiceManager;

    @EventListener
    public void onContextRefreshed(ContextRefreshedEvent event) {
        final var context = event.getApplicationContext();

        final var assetDeploymentServices = context.getBeansOfType(AssetDeployment.class);

        for (var assetDeployment : assetDeploymentServices.values()) {
            assetDeployment.assignAssets();

            deploymentServiceManager.triggerDeployment(assetDeployment);
        }
    }
}
