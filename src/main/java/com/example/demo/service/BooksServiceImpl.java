package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    private static final String EXCEPTION_MESSAGE = "Book not found for this id :: ";

    @Autowired
    BooksRepository repository;

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        Book bookInDb = repository.findById(id).orElseThrow(() ->
                new RuntimeException(EXCEPTION_MESSAGE + id));

        if (book.getBookName() != null) {
            bookInDb.setBookName(book.getBookName());
        }

        if (book.getAuthor() != null) {
            bookInDb.setAuthor(book.getAuthor());
        }

        if (book.getGenre() != null) {
            bookInDb.setGenre(book.getGenre());
        }

        if (book.getNumberOfPages() != null) {
            bookInDb.setNumberOfPages(book.getNumberOfPages());
        }

        if (book.getYearOfPublishing() != null) {
            bookInDb.setYearOfPublishing(book.getYearOfPublishing());
        }

        return repository.save(bookInDb);
    }

    @Override
    public Page<Book> findAllBooks(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Book findBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException
                (EXCEPTION_MESSAGE + id));
    }

    @Override
    public Book findBookByName(String bookName) {
        return repository.findByBookName(bookName)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + bookName));
    }
}
