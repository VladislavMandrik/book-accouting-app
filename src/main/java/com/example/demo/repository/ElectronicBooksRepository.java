package com.example.demo.repository;

import com.example.demo.model.ElectronicBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectronicBooksRepository extends JpaRepository<ElectronicBook, Long> {

    Optional<ElectronicBook> findByElectronicBookName(String electronicBookName);
}