package web.technologies.lab11.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import web.technologies.lab11.model.Book;
import web.technologies.lab11.model.BookStatus;
import web.technologies.lab11.model.Genre;
import web.technologies.lab11.service.BookService;

class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private Book book;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        book = new Book("Brave New World", "Aldous Huxley", 1932, Genre.FICTION, BookStatus.AVAILABLE);
    }

    @Test
    void addBook() {
        when(bookService.addBook(any(Book.class))).thenReturn(book);

        ResponseEntity<Book> response = bookController.addBook(book);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

}

