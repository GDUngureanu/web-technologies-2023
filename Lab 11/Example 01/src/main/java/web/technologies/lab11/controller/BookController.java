package web.technologies.lab11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab11.model.Book;
import web.technologies.lab11.model.BookStatus;
import web.technologies.lab11.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return ResponseEntity.ok(newBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookStatus(@PathVariable Long id, @RequestParam BookStatus status) {
        Book updatedBook = bookService.updateBookStatus(id, status);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> readBook(@PathVariable Long id) {
        final var book = bookService.readBook(id);
        return ResponseEntity.ok(book);
    }

}
