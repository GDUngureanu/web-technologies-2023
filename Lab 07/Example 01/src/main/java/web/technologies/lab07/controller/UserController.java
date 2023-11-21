package web.technologies.lab07.controller;

import static org.springframework.http.HttpStatus.CREATED;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab07.model.User;
import web.technologies.lab07.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping()
    public ResponseEntity<User> registerUser(@RequestBody final User userDetails) {
        final var registeredUser = service.register(userDetails);
        return ResponseEntity.status(CREATED).body(registeredUser);
    }

}
