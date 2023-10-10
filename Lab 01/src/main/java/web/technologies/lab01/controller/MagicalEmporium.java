package web.technologies.lab01.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab01.model.Wand;
import web.technologies.lab01.service.WandCatalogue;

@RestController
@RequestMapping("/api/magical-emporium")
@RequiredArgsConstructor
public class MagicalEmporium {

    private final WandCatalogue catalogue;

    @GetMapping("/wands-log")
    public ResponseEntity<List<Wand>> fetchAllWands() {
        List<Wand> wands = catalogue.listWandsLog();
        return ResponseEntity.ok(wands);
    }

}
