package com.example.demo.service;

import com.example.demo.model.ElectronicBook;
import com.example.demo.repository.ElectronicBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectronicBooksServiceImpl implements ElectronicBooksService {

    private static final String EXCEPTION_MESSAGE = "ElectronicBook not found for this id :: ";

    @Autowired
    ElectronicBooksRepository repository;

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ElectronicBook save(ElectronicBook electronicBook) {
        return repository.save(electronicBook);
    }

    @Override
    public ElectronicBook update(Long id, ElectronicBook electronicBook) {
        ElectronicBook electronicBookInDb = repository.findById(id).orElseThrow(() ->
                new RuntimeException(EXCEPTION_MESSAGE + id));

        if (electronicBook.getElectronicBookName() != null) {
            electronicBookInDb.setElectronicBookName(electronicBook.getElectronicBookName());
        }

        if (electronicBook.getAuthor() != null) {
            electronicBookInDb.setAuthor(electronicBook.getAuthor());
        }

        if (electronicBook.getGenre() != null) {
            electronicBookInDb.setGenre(electronicBook.getGenre());
        }

        if (electronicBook.getNumberOfPages() != null) {
            electronicBookInDb.setNumberOfPages(electronicBook.getNumberOfPages());
        }

        if (electronicBook.getYearOfPublishing() != null) {
            electronicBookInDb.setYearOfPublishing(electronicBook.getYearOfPublishing());
        }

        if (electronicBook.getTextFormat() != null) {
            electronicBookInDb.setTextFormat(electronicBook.getTextFormat());
        }

        if (electronicBook.getDimension() != null) {
            electronicBookInDb.setDimension(electronicBook.getDimension());
        }

        return repository.save(electronicBookInDb);
    }

    @Override
    public Page<ElectronicBook> findAllElectronicBooks(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ElectronicBook findElectronicBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException
                (EXCEPTION_MESSAGE + id));
    }

    @Override
    public ElectronicBook findElectronicBookByName(String electronicBookName) {
        return repository.findByElectronicBookName(electronicBookName)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + electronicBookName));
    }
}
