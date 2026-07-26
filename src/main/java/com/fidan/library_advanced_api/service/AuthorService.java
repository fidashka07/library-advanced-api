package com.fidan.library_advanced_api.service;

import com.fidan.library_advanced_api.dto.request.AuthorRequestDTO;
import com.fidan.library_advanced_api.dto.response.AuthorResponseDTO;

import java.util.List;

public interface AuthorService {

    AuthorResponseDTO create(AuthorRequestDTO dto);

    AuthorResponseDTO getById(Long id);

    List<AuthorResponseDTO> getAll();

    AuthorResponseDTO update(Long id, AuthorRequestDTO dto);

    void delete(Long id);

}