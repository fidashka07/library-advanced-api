package com.fidan.library_advanced_api.service.impl;

import com.fidan.library_advanced_api.entity.Book;
import com.fidan.library_advanced_api.repository.BookRepository;
import com.fidan.library_advanced_api.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> searchBooks(String title, Double minPrice) {

        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContainingIgnoreCase(title);
        }

        if (minPrice != null) {
            return bookRepository.findByPriceGreaterThan(minPrice);
        }

        return bookRepository.findAll();
    }
}