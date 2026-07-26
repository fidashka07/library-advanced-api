package com.fidan.library_advanced_api.controller;

import com.fidan.library_advanced_api.dto.request.BookRequestDTO;
import com.fidan.library_advanced_api.dto.response.BookResponseDTO;
import com.fidan.library_advanced_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookResponseDTO create(@RequestBody BookRequestDTO dto) {

        return bookService.create(dto);
    }

    @GetMapping("/{id}")
    public BookResponseDTO getById(@PathVariable Long id) {

        return bookService.getById(id);
    }

    @GetMapping
    public List<BookResponseDTO> getAll() {

        return bookService.getAll();
    }

    @PutMapping("/{id}")
    public BookResponseDTO update(@PathVariable Long id,
                                  @RequestBody BookRequestDTO dto) {

        return bookService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        bookService.delete(id);
    }

    @GetMapping("/search")
    public List<BookResponseDTO> search(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Long authorId) {

        return bookService.search(title, minPrice, authorId);
    }

}