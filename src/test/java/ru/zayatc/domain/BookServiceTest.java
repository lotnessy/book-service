package ru.zayatc.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;

    @Test
    void createBook() {
        Author author = Author.builder()
                .name("John Doe")
                .build();
        Book book = bookService.createBook("Green Book", author);

        assertEquals("Green Book", book.getTitle());
        assertSame(1, book.getAuthors().size());
        assertTrue(book.getAuthors().contains(author));
    }

    @Test
    void deleteBook() {
        Book book = bookService.createBook("Green Book", Author.builder()
                .name("John Doe")
                .build());

        bookService.deleteBook(book.getId());

        assertThrows(NoSuchElementException.class, () -> {
            bookRepository.findById(book.getId()).get();
        });
    }
}
