package com.fidan.library_advanced_api.repository;

import com.fidan.library_advanced_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}