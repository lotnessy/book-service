package ru.zayatc.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceTest {

    private static final String AUTHOR_NAME = "John Doe";

    @Autowired
    AuthorService authorService;
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void createAuthor() {
        Author author = authorService.createAuthor(AUTHOR_NAME, Book.builder()
                .title("Green Book")
                .build());

        assertNotNull(author);
        assertNotNull(author.getId());
        assertEquals(AUTHOR_NAME, author.getName());
    }

    @Test
    void deleteAuthor() {
        Author author = authorService.createAuthor(AUTHOR_NAME, Book.builder()
                .title("Green Book")
                .build());

        authorService.deleteAuthor(author.getId());

        assertThrows(NoSuchElementException.class, () -> {
            authorRepository.findById(author.getId()).get();
        });
    }
}
