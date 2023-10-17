package web.technologies.lab02.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import web.technologies.lab02.asset.Asset;

@Repository
public class SpringContextRepository implements AssetRepository {

    @Autowired
    private ApplicationContext context;

    @Override
    public Asset getAsset(String qualifier, Class<? extends Asset> clazz) {
        return context.getBean(qualifier, clazz);
    }

}
