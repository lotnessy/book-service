package ru.zayatc.domain;

public interface BookService {

    Book createBook(String title, Author author);
    void deleteBook(Long id);
}
