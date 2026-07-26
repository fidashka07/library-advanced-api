package com.fidan.library_advanced_api.mapper;

import com.fidan.library_advanced_api.dto.response.CategoryResponseDTO;
import com.fidan.library_advanced_api.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponseDTO toResponse(Category category) {

        CategoryResponseDTO dto = new CategoryResponseDTO();

        dto.setId(category.getId());
        dto.setName(category.getName());

        return dto;
    }
}