package com.example.demo.service;

import com.example.demo.model.ElectronicBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ElectronicBooksService {

    void delete(Long id);

    ElectronicBook update(Long id, ElectronicBook electronicBook);

    ElectronicBook save(ElectronicBook electronicBook);

    Page<ElectronicBook> findAllElectronicBooks(Pageable pageable);

    ElectronicBook findElectronicBookById(Long id);

    ElectronicBook findElectronicBookByName(String electronicBookName);
}