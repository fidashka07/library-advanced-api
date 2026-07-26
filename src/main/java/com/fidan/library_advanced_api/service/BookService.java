package com.fidan.library_advanced_api.service;

import com.fidan.library_advanced_api.entity.Book;
import java.util.List;

public interface BookService {

    List<Book> searchBooks(String title, Double minPrice);

}