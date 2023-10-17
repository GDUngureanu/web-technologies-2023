package web.technologies.lab02.service;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import web.technologies.lab02.asset.Asset;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.TIEFighter;

@Getter
@Component
public class DeathStarDeployment implements AssetDeployment {

    private final List<Asset> assets;

    public DeathStarDeployment(
        @Qualifier("Devastator") StarDestroyer devastator,
        @Qualifier("ALPHA-001") TIEFighter tieAlpha,
        @Qualifier("BRAVO-002") TIEFighter tieBravo,
        @Qualifier("CHARLIE-003") TIEFighter tieCharlie,
        @Qualifier("BF-Original") BobaFett bobaOriginal) {
        this.assets = Arrays.asList(devastator, tieAlpha, tieBravo, tieCharlie, bobaOriginal);
    }

    public String deploymentShout() {
        return "Special operations are now in progress!";
    }

}
