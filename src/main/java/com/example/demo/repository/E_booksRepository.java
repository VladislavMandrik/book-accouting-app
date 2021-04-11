package com.example.demo.repository;

import com.example.demo.model.E_books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface E_booksRepository extends JpaRepository<E_books, Long> {

    Optional<E_books> findByFirstName(String firstName);
}