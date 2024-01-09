package web.technologies.lab11.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import web.technologies.lab11.model.Book;
import web.technologies.lab11.model.BookStatus;
import web.technologies.lab11.model.Genre;
import web.technologies.lab11.repository.BookRepository;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        book = new Book("1984", "George Orwell", 1949, Genre.FICTION, BookStatus.AVAILABLE);
    }

    @Test
    void addBookSuccess() {
        when(bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor())).thenReturn(Optional.empty());
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book savedBook = bookService.addBook(book);
        assertNotNull(savedBook);
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void addBookFailureAlreadyExists() {
        when(bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor())).thenReturn(Optional.of(book));

        assertThrows(IllegalStateException.class, () -> bookService.addBook(book));
        verify(bookRepository, never()).save(any(Book.class));
    }

}
