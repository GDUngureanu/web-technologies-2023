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
public class FrontierPatrol implements AssetDeployment {

    private final List<Asset> assets;

    public FrontierPatrol(
        @Qualifier("Executor") StarDestroyer executor,
        @Qualifier("Interceptor") StarDestroyer interceptor,
        @Qualifier("HOTEL-008") TIEFighter tieHotel,
        @Qualifier("BF-Alpha") BobaFett bobaAlpha,
        @Qualifier("BF-Bravo") BobaFett bobaBravo) {
        this.assets = Arrays.asList(executor, interceptor, tieHotel, bobaAlpha, bobaBravo);
    }

    public String deploymentShout() {
        return "Defense operations are now active!";
    }

}