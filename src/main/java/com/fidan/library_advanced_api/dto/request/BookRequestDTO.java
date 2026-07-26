package com.fidan.library_advanced_api.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class BookRequestDTO {

    private String title;

    private Double price;

    private Long authorId;

    private Set<Long> categoryIds;
}