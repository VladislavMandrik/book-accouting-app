package com.example.demo.controller;

import com.example.demo.model.ElectronicBook;
import com.example.demo.service.ElectronicBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ElectronicBooksController {
    @Autowired
    private ElectronicBooksService service;

    @GetMapping("/electronicBooks")
    public ResponseEntity<List<ElectronicBook>> getAllE_Books() {
        return ResponseEntity.ok().body(service.findAllElectronicBooks());
    }

    @GetMapping("/electronicBooks/{id}")
    public ResponseEntity<ElectronicBook> getE_BookById(@PathVariable(value = "id") Long id) {
        ElectronicBook electronicBook = service.findElectronicBookById(id);
        return ResponseEntity.ok().body(electronicBook);
    }

    @PostMapping("/electronicBooks")
    public ResponseEntity<ElectronicBook> createE_Book(@RequestBody ElectronicBook electronicBook) {
        return ResponseEntity.ok().body(service.save(electronicBook));
    }

    @PutMapping("/electronicBooks/{id}")
    public ResponseEntity<ElectronicBook> updateE_Book(
            @PathVariable Long id,
            @RequestBody ElectronicBook electronicBook) {
        ElectronicBook updatedElectronicBook = service.update(id, electronicBook);
        return ResponseEntity.ok(updatedElectronicBook);
    }

    @DeleteMapping("/electronicBooks/{id}")
    public ResponseEntity<Void> deleteE_Book(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}