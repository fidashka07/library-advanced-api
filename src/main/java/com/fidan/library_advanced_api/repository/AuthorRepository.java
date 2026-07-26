package com.fidan.library_advanced_api.repository;

import com.fidan.library_advanced_api.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}