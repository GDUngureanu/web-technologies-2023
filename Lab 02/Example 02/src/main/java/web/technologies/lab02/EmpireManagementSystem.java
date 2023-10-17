package web.technologies.lab02;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.technologies.lab02.service.AssetDeployment;

public class EmpireManagementSystem {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("web.technologies.lab02");

        Map<String, AssetDeployment> assetDeploymentServices = context.getBeansOfType(AssetDeployment.class);
        for (var service : assetDeploymentServices.values()) {
            service.deployAssets();
        }
    }

}