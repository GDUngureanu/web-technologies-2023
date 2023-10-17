package web.technologies.lab02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.technologies.lab02.service.UnifiedAsset;

public class EmpireManagementSystem {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("web.technologies.lab02");

        UnifiedAsset unifiedAsset = context.getBean(UnifiedAsset.class);
        unifiedAsset.deployAssets();
    }

}