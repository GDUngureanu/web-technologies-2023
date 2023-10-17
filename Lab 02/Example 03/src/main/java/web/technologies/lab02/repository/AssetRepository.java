package web.technologies.lab02.repository;

import web.technologies.lab02.asset.Asset;

public interface AssetRepository {

    Asset getAsset(String qualifier, Class<? extends Asset> clazz);

}
