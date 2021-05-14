package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BooksController {
    @Autowired
    private BooksService service;

    @GetMapping("/books")
    public ResponseEntity<Page<Book>> getAllBooks(
            @PageableDefault(sort = "id", size = 3)Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllBooks(pageable));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long id) {
        Book book = service.findBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/books/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable(value = "name") String name) {
        Book book = service.findBookByName(name);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(service.save(book));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @RequestBody Book book) {
        Book updatedBook = service.update(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}