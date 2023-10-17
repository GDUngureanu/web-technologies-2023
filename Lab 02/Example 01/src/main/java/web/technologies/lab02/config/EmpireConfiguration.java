package web.technologies.lab02.config;

import org.springframework.context.annotation.Bean;
import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;

public class EmpireConfiguration {

    @Bean
    public StarDestroyer devastator() {
        return new StarDestroyer("Devastator", "Darth Vader", "Death Squadron", 72, "Active");
    }

    @Bean
    public StarDestroyer executor() {
        return new StarDestroyer("Executor", "Firmus Piett", "Executor Fleet", 144, "Active");
    }

    @Bean
    public StarDestroyer avenger() {
        return new StarDestroyer("Avenger", "Lorth Needa", "Death Squadron", 72, "Under Repair");
    }

    @Bean
    public TIEFighter tieAlpha() {
        return new TIEFighter("ALPHA-001", "Mauler Mithel", 2, "Active", 50);
    }

    @Bean
    public TIEFighter tieBravo() {
        return new TIEFighter("BRAVO-002", "Backstabber", 2, "Active", 40);
    }

    @Bean
    public TIEFighter tieCharlie() {
        return new TIEFighter("CHARLIE-003", "Dark Curse", 2, "Damaged", 60);
    }

    @Bean
    public TIEFighter tieDelta() {
        return new TIEFighter("DELTA-004", "Night Beast", 2, "Active", 30);
    }

    @Bean
    public TIEFighter tieEcho() {
        return new TIEFighter("ECHO-005", "Scourge", 2, "Active", 70);
    }

    @Bean
    public TIEFighter tieFoxtrot() {
        return new TIEFighter("FOXTROT-006", "Blackout", 2, "Damaged", 40);
    }

    @Bean
    public TIEFighter tieGolf() {
        return new TIEFighter("GOLF-007", "Shadow", 2, "Active", 20);
    }

    @Bean
    public TIEFighter tieHotel() {
        return new TIEFighter("HOTEL-008", "Whisper", 2, "Active", 15);
    }

    @Bean
    public Stormtrooper trooperAlpha() {
        return new Stormtrooper("TK-001", "Private", "Tatooine Patrol", 60, "E-11 Blaster Rifle");
    }

    @Bean
    public Stormtrooper trooperBravo() {
        return new Stormtrooper("TK-002", "Sergeant", "Death Star Guard", 80, "E-11 Blaster Rifle");
    }

    @Bean
    public Stormtrooper trooperCharlie() {
        return new Stormtrooper("TK-003", "Private", "Endor Moon Patrol", 65, "DLT-19 Heavy Blaster Rifle");
    }

    @Bean
    public Stormtrooper trooperDelta() {
        return new Stormtrooper("TK-004", "Captain", "Imperial Base Defense", 85, "SE-14r Light Repeating Blaster");
    }

    @Bean
    public Stormtrooper trooperEcho() {
        return new Stormtrooper("TK-005", "Private", "Hoth Reconnaissance", 70, "E-11 Blaster Rifle");
    }

    @Bean
    public BobaFett bobaOriginal() {
        return new BobaFett("BF-Original", "EE-3 Carbine Rifle", "Han Solo", 10000);
    }

    @Bean
    public BobaFett bobaAlpha() {
        return new BobaFett("BF-Alpha", "BlasTech Dur-24 Wrist Laser", "Jabba the Hutt", 8000);
    }

    @Bean
    public BobaFett bobaBravo() {
        return new BobaFett("BF-Bravo", "EE-3 Carbine Rifle", "Chewbacca", 7000);
    }

}
