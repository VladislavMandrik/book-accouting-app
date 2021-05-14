package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BooksService {

    void delete(Long id);

    Book update(Long id, Book book);

    Book save(Book book);

    Page<Book> findAllBooks(Pageable pageable);

    Book findBookById(Long id);

    Book findBookByName(String bookName);

}
