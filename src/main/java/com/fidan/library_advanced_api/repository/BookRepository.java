package com.fidan.library_advanced_api.repository;

import com.fidan.library_advanced_api.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>,
        JpaSpecificationExecutor<Book> {

    @EntityGraph(attributePaths = {"author", "categories"})
    List<Book> findAll();

    @Query("""
            SELECT b
            FROM Book b
            WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))
            """)
    List<Book> searchByTitle(@Param("title") String title);

    @Query("""
            SELECT b
            FROM Book b
            WHERE b.price >= :price
            """)
    List<Book> findBooksWithPriceGreaterThan(@Param("price") Double price);

    @Query("""
            SELECT b
            FROM Book b
            JOIN FETCH b.author
            JOIN FETCH b.categories
            """)
    List<Book> findAllWithRelations();

}