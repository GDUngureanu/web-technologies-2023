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
public class EndorDeployment implements AssetDeployment {


    private final List<Asset> assets;

    public EndorDeployment(
        @Qualifier("Avenger") StarDestroyer avenger,
        @Qualifier("CHARLIE-003") TIEFighter tieCharlie,
        @Qualifier("GOLF-007") TIEFighter tieGolf,
        @Qualifier("BF-Bravo") BobaFett bobaBravo,
        @Qualifier("BF-Clone") BobaFett bobaClone) {
        this.assets = Arrays.asList(avenger, tieCharlie, tieGolf, bobaBravo, bobaClone);
    }

    public String deploymentShout() {
        return "Galactic patrol has been successfully commenced!";
    }

}
