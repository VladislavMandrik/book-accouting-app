package com.example.demo.controller;

import com.example.demo.model.ElectronicBook;
import com.example.demo.service.ElectronicBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ElectronicBooksController {
    @Autowired
    private ElectronicBooksService service;

    @GetMapping("/electronic-books")
    public ResponseEntity<Page<ElectronicBook>> getAllElectronicBooks(
            @PageableDefault(sort = "id", size = 3)Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllElectronicBooks(pageable));
    }

    @GetMapping("/electronic-books/{id}")
    public ResponseEntity<ElectronicBook> getElectronicBookById(@PathVariable(value = "id") Long id) {
        ElectronicBook electronicBook = service.findElectronicBookById(id);
        return ResponseEntity.ok().body(electronicBook);
    }

    @GetMapping("/electronic-books/{name}")
    public ResponseEntity<ElectronicBook> getElectronicBookByName(@PathVariable(value = "name") String name) {
        ElectronicBook electronicBook = service.findElectronicBookByName(name);
        return ResponseEntity.ok().body(electronicBook);
    }

    @PostMapping("/electronic-books")
    public ResponseEntity<ElectronicBook> createElectronicBook(@RequestBody ElectronicBook electronicBook) {
        return ResponseEntity.ok().body(service.save(electronicBook));
    }

    @PutMapping("/electronic-books/{id}")
    public ResponseEntity<ElectronicBook> updateElectronicBook(
            @PathVariable Long id,
            @RequestBody ElectronicBook electronicBook) {
        ElectronicBook updatedElectronicBook = service.update(id, electronicBook);
        return ResponseEntity.ok(updatedElectronicBook);
    }

    @DeleteMapping("/electronic-books/{id}")
    public ResponseEntity<Void> deleteElectronicBook(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}