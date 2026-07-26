package com.fidan.library_advanced_api.service.impl;

import com.fidan.library_advanced_api.dto.request.BookRequestDTO;
import com.fidan.library_advanced_api.dto.response.BookResponseDTO;
import com.fidan.library_advanced_api.entity.Author;
import com.fidan.library_advanced_api.entity.Book;
import com.fidan.library_advanced_api.entity.Category;
import com.fidan.library_advanced_api.exception.ResourceNotFoundException;
import com.fidan.library_advanced_api.mapper.BookMapper;
import com.fidan.library_advanced_api.repository.AuthorRepository;
import com.fidan.library_advanced_api.repository.BookRepository;
import com.fidan.library_advanced_api.repository.CategoryRepository;
import com.fidan.library_advanced_api.service.BookService;
import com.fidan.library_advanced_api.specification.BookSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponseDTO create(BookRequestDTO dto) {

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Author not found"));

        Set<Category> categories = new HashSet<>(
                categoryRepository.findAllById(dto.getCategoryIds())
        );

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setPrice(dto.getPrice());
        book.setAuthor(author);
        book.setCategories(categories);

        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public BookResponseDTO getById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found"));

        return bookMapper.toResponse(book);
    }

    @Override
    public List<BookResponseDTO> getAll() {

        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    @Override
    public BookResponseDTO update(Long id, BookRequestDTO dto) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found"));

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Author not found"));

        Set<Category> categories = new HashSet<>(
                categoryRepository.findAllById(dto.getCategoryIds())
        );

        book.setTitle(dto.getTitle());
        book.setPrice(dto.getPrice());
        book.setAuthor(author);
        book.setCategories(categories);

        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {

        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponseDTO> search(String title,
                                        Double minPrice,
                                        Long authorId) {

        Specification<Book> specification =
                Specification.where(BookSpecification.hasTitle(title))
                        .and(BookSpecification.hasMinPrice(minPrice))
                        .and(BookSpecification.hasAuthor(authorId));

        return bookRepository.findAll(specification)
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }
}