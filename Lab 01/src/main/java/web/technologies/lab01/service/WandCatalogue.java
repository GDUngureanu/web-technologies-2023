package web.technologies.lab01.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.technologies.lab01.mapper.WandDecipher;
import web.technologies.lab01.model.Wand;
import web.technologies.lab01.repository.OllivandersWandShop;

@Service
@RequiredArgsConstructor
public class WandCatalogue {

    private final OllivandersWandShop wandShop;

    private final WandDecipher wandDecipher;

    public List<Wand> listWandsLog() {
        return wandDecipher.toWand(wandShop.findAll());
    }

}
