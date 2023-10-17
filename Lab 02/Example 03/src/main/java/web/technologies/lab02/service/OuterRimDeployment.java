package web.technologies.lab02.service;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.technologies.lab02.asset.Asset;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.TIEFighter;
import web.technologies.lab02.repository.AssetRepository;

@Getter
@Component
public class OuterRimDeployment implements AssetDeployment {


    private List<Asset> assets;

    @Autowired
    private AssetRepository assetRepository;

    public void assignAssets() {
        this.assets = Arrays.asList(
            assetRepository.getAsset("Executor", StarDestroyer.class),
            assetRepository.getAsset("DELTA-004", TIEFighter.class),
            assetRepository.getAsset("ECHO-005", TIEFighter.class),
            assetRepository.getAsset("FOXTROT-006", TIEFighter.class),
            assetRepository.getAsset("ZETA-007", TIEFighter.class),
            assetRepository.getAsset("BF-Alpha", BobaFett.class),
            assetRepository.getAsset("BF-Clone", BobaFett.class)
        );
    }

    public String deploymentShout() {
        return "All assets have been successfully deployed!";
    }

}
