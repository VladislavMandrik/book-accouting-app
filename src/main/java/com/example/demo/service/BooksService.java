package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    void delete(Long id);

    Book update(Long id, Book book);

    Book save(Book book);

    List<Book> findAllBooks();

    Book findBookById(Long id);

    Optional<Book> findBookByName(String bookName);
}
