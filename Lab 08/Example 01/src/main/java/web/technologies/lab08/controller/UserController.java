package web.technologies.lab08.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab08.model.User;
import web.technologies.lab08.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody final User userDetails) {
        final var registeredUser = service.create(userDetails);

        return ResponseEntity.status(CREATED).body(registeredUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable UUID id) {
        final var loggedInUser = service.get(id);
        return ResponseEntity.status(OK).body(loggedInUser);
    }

}
