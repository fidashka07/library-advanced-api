package com.fidan.library_advanced_api.service.impl;

import com.fidan.library_advanced_api.dto.request.BorrowRecordRequestDTO;
import com.fidan.library_advanced_api.dto.response.BorrowRecordResponseDTO;
import com.fidan.library_advanced_api.entity.Book;
import com.fidan.library_advanced_api.entity.BorrowRecord;
import com.fidan.library_advanced_api.exception.ResourceNotFoundException;
import com.fidan.library_advanced_api.mapper.BorrowRecordMapper;
import com.fidan.library_advanced_api.repository.BookRepository;
import com.fidan.library_advanced_api.repository.BorrowRecordRepository;
import com.fidan.library_advanced_api.service.BorrowRecordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;
    private final BorrowRecordMapper borrowRecordMapper;

    @Override
    @Transactional
    public BorrowRecordResponseDTO borrowBook(BorrowRecordRequestDTO dto) {

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        BorrowRecord record = new BorrowRecord();
        record.setBook(book);
        record.setBorrowerName(dto.getBorrowerName());
        record.setBorrowDate(LocalDate.now());

        return borrowRecordMapper.toResponse(
                borrowRecordRepository.save(record)
        );
    }

    @Override
    public List<BorrowRecordResponseDTO> getAll() {

        return borrowRecordRepository.findAll()
                .stream()
                .map(borrowRecordMapper::toResponse)
                .toList();
    }

    @Override
    public BorrowRecordResponseDTO getById(Long id) {

        BorrowRecord record = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found"));

        return borrowRecordMapper.toResponse(record);
    }

    @Override
    public void delete(Long id) {

        borrowRecordRepository.deleteById(id);
    }
}