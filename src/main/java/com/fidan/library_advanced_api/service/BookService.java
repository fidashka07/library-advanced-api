package com.fidan.library_advanced_api.service;

import com.fidan.library_advanced_api.dto.request.BookRequestDTO;
import com.fidan.library_advanced_api.dto.response.BookResponseDTO;

import java.util.List;

public interface BookService {

    BookResponseDTO create(BookRequestDTO dto);

    BookResponseDTO getById(Long id);

    List<BookResponseDTO> getAll();

    BookResponseDTO update(Long id, BookRequestDTO dto);

    void delete(Long id);

    List<BookResponseDTO> search(String title,
                                 Double minPrice,
                                 Long authorId);

}