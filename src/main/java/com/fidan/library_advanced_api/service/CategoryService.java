package com.fidan.library_advanced_api.service;

import com.fidan.library_advanced_api.dto.request.CategoryRequestDTO;
import com.fidan.library_advanced_api.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO create(CategoryRequestDTO dto);

    CategoryResponseDTO getById(Long id);

    List<CategoryResponseDTO> getAll();

    CategoryResponseDTO update(Long id, CategoryRequestDTO dto);

    void delete(Long id);

}