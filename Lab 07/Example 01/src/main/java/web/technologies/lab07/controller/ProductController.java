package web.technologies.lab07.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.technologies.lab07.request.CreateProductRequest;
import web.technologies.lab07.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestHeader final UUID userId,
            @RequestBody final CreateProductRequest request) {
        userService.isDistributor(userId);
        
        System.out.println(request);
        
        return ResponseEntity.noContent().build();
    }
    
    
}
