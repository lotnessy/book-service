package ru.zayatc.domain;

public interface AuthorService {

    Author createAuthor(String name, Book book);
    void deleteAuthor(Long id);
}
