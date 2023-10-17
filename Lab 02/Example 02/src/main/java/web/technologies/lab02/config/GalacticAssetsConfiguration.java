package web.technologies.lab02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

@Configuration
public class GalacticAssetsConfiguration {

    @Bean
    public StarDestroyer interceptor() {
        return new StarDestroyer("Interceptor", "Admiral Ozzel", "Vader's Fleet", 55, "Under Maintenance");
    }

    @Bean
    public TIEFighter tieZeta() {
        return new TIEFighter("ZETA-007", "DS-61-4", 2, "Damaged", 80);
    }

    @Bean
    public Stormtrooper trooperZulu() {
        return new Stormtrooper("TK-099", "Sergeant", "Cloud City Guard", 75, "DLT-19D Heavy Blaster Rifle");
    }

    @Bean
    public BobaFett bobaClone() {
        return new BobaFett("BF-Clone", "Vibroblade", "Cad Bane", 12000);
    }

}
