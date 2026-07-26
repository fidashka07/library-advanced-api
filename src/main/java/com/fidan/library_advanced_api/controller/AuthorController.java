package com.fidan.library_advanced_api.controller;

import com.fidan.library_advanced_api.dto.request.AuthorRequestDTO;
import com.fidan.library_advanced_api.dto.response.AuthorResponseDTO;
import com.fidan.library_advanced_api.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public AuthorResponseDTO create(@RequestBody AuthorRequestDTO dto) {
        return authorService.create(dto);
    }

    @GetMapping("/{id}")
    public AuthorResponseDTO getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @GetMapping
    public List<AuthorResponseDTO> getAll() {
        return authorService.getAll();
    }

    @PutMapping("/{id}")
    public AuthorResponseDTO update(@PathVariable Long id,
                                    @RequestBody AuthorRequestDTO dto) {
        return authorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}