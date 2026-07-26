package com.fidan.library_advanced_api.service.impl;

import com.fidan.library_advanced_api.dto.request.CategoryRequestDTO;
import com.fidan.library_advanced_api.dto.response.CategoryResponseDTO;
import com.fidan.library_advanced_api.entity.Category;
import com.fidan.library_advanced_api.exception.ResourceNotFoundException;
import com.fidan.library_advanced_api.mapper.CategoryMapper;
import com.fidan.library_advanced_api.repository.CategoryRepository;
import com.fidan.library_advanced_api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO dto) {

        Category category = new Category();
        category.setName(dto.getName());

        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDTO getById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return categoryMapper.toResponse(category);
    }

    @Override
    public List<CategoryResponseDTO> getAll() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(dto.getName());

        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {

        categoryRepository.deleteById(id);
    }
}