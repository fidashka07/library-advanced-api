package com.fidan.library_advanced_api.service.impl;

import com.fidan.library_advanced_api.entity.Book;
import com.fidan.library_advanced_api.entity.BorrowRecord;
import com.fidan.library_advanced_api.repository.BookRepository;
import com.fidan.library_advanced_api.repository.BorrowRecordRepository;
import com.fidan.library_advanced_api.service.BorrowRecordService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BookRepository bookRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    public BorrowRecordServiceImpl(BookRepository bookRepository,
                                   BorrowRecordRepository borrowRecordRepository) {
        this.bookRepository = bookRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    @Override
    @Transactional
    public BorrowRecord borrowBook(Long bookId, String borrowerName) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BorrowRecord record = new BorrowRecord();
        record.setBook(book);
        record.setBorrowerName(borrowerName);
        record.setBorrowDate(LocalDate.now());

        return borrowRecordRepository.save(record);
    }
}