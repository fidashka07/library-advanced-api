package com.fidan.library_advanced_api.mapper;

import com.fidan.library_advanced_api.dto.response.AuthorResponseDTO;
import com.fidan.library_advanced_api.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorResponseDTO toResponse(Author author) {

        AuthorResponseDTO dto = new AuthorResponseDTO();

        dto.setId(author.getId());
        dto.setName(author.getName());

        return dto;
    }
}