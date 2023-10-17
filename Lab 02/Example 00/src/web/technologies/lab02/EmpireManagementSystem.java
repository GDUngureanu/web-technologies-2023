package web.technologies.lab02;

import web.technologies.lab02.asset.BobaFett;
import web.technologies.lab02.asset.StarDestroyer;
import web.technologies.lab02.asset.Stormtrooper;
import web.technologies.lab02.asset.TIEFighter;
import web.technologies.lab02.service.UnifiedAsset;

public class EmpireManagementSystem {

    public static void main(String[] args) {
        StarDestroyer starDestroyer = new StarDestroyer("Interceptor", "Admiral Ozzel", "Vader's Fleet", 55, "Under Maintenance");
        TIEFighter tieFighter = new TIEFighter("ZETA-007", "DS-61-4", 2, "Damaged", 80);
        Stormtrooper stormtrooper = new Stormtrooper("TK-099", "Sergeant", "Cloud City Guard", 75, "DLT-19D Heavy Blaster Rifle");
        BobaFett bobaFett = new BobaFett("BF-Clone", "Vibroblade", "Cad Bane", 12000);

        UnifiedAsset unifiedAsset = new UnifiedAsset(starDestroyer, tieFighter, stormtrooper, bobaFett);
        unifiedAsset.deployAssets();
    }

}