package web.technologies.lab02.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.TIEFighter;

@Configuration
public class EmpireConfiguration {

    @Bean(name = "Devastator")
    public StarDestroyer devastator() {
        return new StarDestroyer("Devastator", "Darth Vader", "Death Squadron", 72, "Active");
    }

    @Bean(name = "Executor")
    public StarDestroyer executor() {
        return new StarDestroyer("Executor", "Firmus Piett", "Executor Fleet", 144, "Active");
    }

    @Bean(name = "Avenger")
    public StarDestroyer avenger() {
        return new StarDestroyer("Avenger", "Lorth Needa", "Death Squadron", 72, "Under Repair");
    }

    @Bean(name = "Interceptor")
    public StarDestroyer interceptor() {
        return new StarDestroyer("Interceptor", "Admiral Ozzel", "Vader's Fleet", 55, "Under Maintenance");
    }

    @Bean(name = "ALPHA-001")
    public TIEFighter tieAlpha() {
        return new TIEFighter("ALPHA-001", "Mauler Mithel", 2, "Active", 50);
    }

    @Bean(name = "BRAVO-002")
    public TIEFighter tieBravo() {
        return new TIEFighter("BRAVO-002", "Backstabber", 2, "Active", 40);
    }

    @Bean(name = "CHARLIE-003")
    public TIEFighter tieCharlie() {
        return new TIEFighter("CHARLIE-003", "Dark Curse", 2, "Damaged", 60);
    }

    @Bean(name = "DELTA-004")
    public TIEFighter tieDelta() {
        return new TIEFighter("DELTA-004", "Night Beast", 2, "Active", 30);
    }

    @Bean(name = "ECHO-005")
    public TIEFighter tieEcho() {
        return new TIEFighter("ECHO-005", "Scourge", 2, "Active", 70);
    }

    @Bean(name = "FOXTROT-006")
    public TIEFighter tieFoxtrot() {
        return new TIEFighter("FOXTROT-006", "Blackout", 2, "Damaged", 40);
    }

    @Bean(name = "GOLF-007")
    public TIEFighter tieGolf() {
        return new TIEFighter("GOLF-007", "Shadow", 2, "Active", 20);
    }

    @Bean(name = "HOTEL-008")
    public TIEFighter tieHotel() {
        return new TIEFighter("HOTEL-008", "Whisper", 2, "Active", 15);
    }

    @Bean(name = "ZETA-007")
    public TIEFighter tieZeta() {
        return new TIEFighter("ZETA-007", "DS-61-4", 2, "Damaged", 80);
    }

    @Bean(name = "BF-Original")
    public BobaFett bobaOriginal() {
        return new BobaFett("BF-Original", "EE-3 Carbine Rifle", "Han Solo", 10000);
    }

    @Bean(name = "BF-Alpha")
    public BobaFett bobaAlpha() {
        return new BobaFett("BF-Alpha", "BlasTech Dur-24 Wrist Laser", "Jabba the Hutt", 8000);
    }

    @Bean()
    @Qualifier("BF-Bravo")
    public BobaFett bobaBravo() {
        return new BobaFett("BF-Bravo", "EE-3 Carbine Rifle", "Chewbacca", 7000);
    }

    @Bean(name = "BF-Clone")
    public BobaFett bobaClone() {
        return new BobaFett("BF-Clone", "Vibroblade", "Cad Bane", 12000);
    }

}
