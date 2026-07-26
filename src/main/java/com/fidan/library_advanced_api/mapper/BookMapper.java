package com.fidan.library_advanced_api.mapper;

import com.fidan.library_advanced_api.dto.response.BookResponseDTO;
import com.fidan.library_advanced_api.entity.Book;
import com.fidan.library_advanced_api.entity.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookResponseDTO toResponse(Book book) {

        BookResponseDTO dto = new BookResponseDTO();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setPrice(book.getPrice());

        if (book.getAuthor() != null) {
            dto.setAuthorName(book.getAuthor().getName());
        }

        if (book.getCategories() != null) {
            dto.setCategories(
                    book.getCategories()
                            .stream()
                            .map(Category::getName)
                            .collect(Collectors.toSet())
            );
        }

        return dto;
    }
}