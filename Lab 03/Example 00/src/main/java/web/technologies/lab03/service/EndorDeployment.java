package web.technologies.lab03.service;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.technologies.lab03.asset.Asset;
import web.technologies.lab03.asset.TIEFighter;

@Getter
@NoArgsConstructor
public class EndorDeployment implements AssetDeployment {

    private TIEFighter tieAlpha;

    private TIEFighter tieBravo;

    private List<Asset> assets;

    public void assignAssets() {
        this.assets = Arrays.asList(tieAlpha, tieBravo);
    }

    public String deploymentShout() {
        return "Galactic patrol has been successfully commenced!";
    }

}
