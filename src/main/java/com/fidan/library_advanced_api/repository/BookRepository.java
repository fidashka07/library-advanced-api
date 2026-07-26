package com.fidan.library_advanced_api.repository;

import com.fidan.library_advanced_api.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    @EntityGraph(attributePaths = {"author", "categories"})
    List<Book> findAll();
}