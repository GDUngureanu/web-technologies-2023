package web.technologies.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.technologies.lab02.logger.ActionLogger;

public abstract class AssetDeployment {

    @Autowired
    protected ActionLogger actionLogger;

    public abstract void deployAssets();

}
