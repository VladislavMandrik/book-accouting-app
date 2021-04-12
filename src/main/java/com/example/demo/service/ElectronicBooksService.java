package com.example.demo.service;

import com.example.demo.model.ElectronicBook;

import java.util.List;
import java.util.Optional;

public interface ElectronicBooksService {

    void delete(Long id);

    ElectronicBook update(Long id, ElectronicBook electronicBook);

    ElectronicBook save(ElectronicBook electronicBook);

    List<ElectronicBook> findAllElectronicBooks();

    ElectronicBook findElectronicBookById(Long id);

    Optional<ElectronicBook> findElectronicBookByName(String electronicBookName);
}