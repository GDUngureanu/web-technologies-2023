package web.technologies.lab08.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.technologies.lab08.model.User;
import web.technologies.lab08.request.UserUpdateRequest;
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

    @GetMapping()
    public ResponseEntity<List<User>> searchByName(@RequestParam String name) {
        final var users = service.findByName(name);
        return ResponseEntity.status(OK).body(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody final UserUpdateRequest newUserDetails) {
        service.update(id, newUserDetails);
        return ResponseEntity.noContent().build();
    }

}
