package web.technologies.lab11.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab11.model.Book;
import web.technologies.lab11.model.BookStatus;
import web.technologies.lab11.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(final Book book) {
        // Check for duplicate book
        Optional<Book> existingBook = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor());

        if (existingBook.isPresent()) {
            // Handle the case where the book already exists, maybe throw an exception
            throw new IllegalStateException("Book already exists");
        }

        return bookRepository.save(book);
    }

    public Book updateBookStatus(final Long id, final BookStatus status) {
        final var book = bookRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("Book with id " + id + " does not exist"));

        book.setStatus(status);

        return bookRepository.save(book);
    }

    public Book readBook(final Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("Book with id " + id + " does not exist"));
    }

}
