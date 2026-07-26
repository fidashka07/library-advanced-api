package com.fidan.library_advanced_api.repository;

import com.fidan.library_advanced_api.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByPriceGreaterThan(Double price);

    List<Book> findByAuthorName(String authorName);

    @Query("SELECT b FROM Book b WHERE b.price BETWEEN :minPrice AND :maxPrice")
    List<Book> findBooksByPriceRange(Double minPrice, Double maxPrice);

    @EntityGraph(attributePaths = {"author", "categories"})
    @Query("SELECT b FROM Book b")
    List<Book> findAllWithAuthorAndCategories();

    @EntityGraph(attributePaths = {"author", "categories"})
    List<Book> findAll();

    @Query("SELECT b FROM Book b JOIN FETCH b.author")
    List<Book> findAllBooksWithAuthors();

    @Query("""
       SELECT DISTINCT b
       FROM Book b
       LEFT JOIN FETCH b.author
       LEFT JOIN FETCH b.categories
       """)
    List<Book> findAllWithDetails();
}