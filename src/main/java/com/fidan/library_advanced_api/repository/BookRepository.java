package com.fidan.library_advanced_api.repository;

import com.fidan.library_advanced_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContaining(String title);

    List<Book> findByPriceGreaterThan(Double price);

    @Query("SELECT b FROM Book b WHERE b.author.name = :authorName")
    List<Book> findBooksByAuthorName(String authorName);

}