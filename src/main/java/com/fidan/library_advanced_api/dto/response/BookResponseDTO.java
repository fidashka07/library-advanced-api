package com.fidan.library_advanced_api.dto.response;

import lombok.Data;

import java.util.Set;

@Data
public class BookResponseDTO {

    private Long id;

    private String title;

    private Double price;

    private String authorName;

    private Set<String> categories;
}