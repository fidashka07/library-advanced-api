package com.fidan.library_advanced_api.service.impl;

import com.fidan.library_advanced_api.dto.request.AuthorRequestDTO;
import com.fidan.library_advanced_api.dto.response.AuthorResponseDTO;
import com.fidan.library_advanced_api.entity.Author;
import com.fidan.library_advanced_api.exception.ResourceNotFoundException;
import com.fidan.library_advanced_api.mapper.AuthorMapper;
import com.fidan.library_advanced_api.repository.AuthorRepository;
import com.fidan.library_advanced_api.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponseDTO create(AuthorRequestDTO dto) {

        Author author = new Author();
        author.setName(dto.getName());

        return authorMapper.toResponse(authorRepository.save(author));
    }

    @Override
    public AuthorResponseDTO getById(Long id) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));

        return authorMapper.toResponse(author);
    }

    @Override
    public List<AuthorResponseDTO> getAll() {

        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }

    @Override
    public AuthorResponseDTO update(Long id, AuthorRequestDTO dto) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));

        author.setName(dto.getName());

        return authorMapper.toResponse(authorRepository.save(author));
    }

    @Override
    public void delete(Long id) {

        authorRepository.deleteById(id);
    }
}