package com.fidan.library_advanced_api.controller;

import com.fidan.library_advanced_api.dto.request.CategoryRequestDTO;
import com.fidan.library_advanced_api.dto.response.CategoryResponseDTO;
import com.fidan.library_advanced_api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponseDTO create(@RequestBody CategoryRequestDTO dto) {
        return categoryService.create(dto);
    }

    @GetMapping("/{id}")
    public CategoryResponseDTO getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @GetMapping
    public List<CategoryResponseDTO> getAll() {
        return categoryService.getAll();
    }

    @PutMapping("/{id}")
    public CategoryResponseDTO update(@PathVariable Long id,
                                      @RequestBody CategoryRequestDTO dto) {
        return categoryService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}