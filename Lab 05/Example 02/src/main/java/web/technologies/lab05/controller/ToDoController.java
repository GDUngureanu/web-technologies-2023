package web.technologies.lab05.controller;

import java.util.Collection;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab05.model.Item;
import web.technologies.lab05.service.ToDoService;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item created = toDoService.create(item);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        Item item = toDoService.findById(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Item>> getAllItems() {
        return ResponseEntity.ok(toDoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updated = toDoService.update(id, item);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> markAsDone(@PathVariable Long id) {
        toDoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
