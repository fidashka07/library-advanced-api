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

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;
    private final BorrowRecordMapper borrowRecordMapper;

    @Override
    @Transactional
    public BorrowRecordResponseDTO create(BorrowRecordRequestDTO dto) {

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        BorrowRecord borrowRecord = borrowRecordMapper.toEntity(dto);
        borrowRecord.setBook(book);

        return borrowRecordMapper.toDTO(
                borrowRecordRepository.save(borrowRecord)
        );
    }

    @Override
    public List<BorrowRecordResponseDTO> getAll() {

        return borrowRecordRepository.findAll()
                .stream()
                .map(borrowRecordMapper::toDTO)
                .toList();
    }

    @Override
    public BorrowRecordResponseDTO getById(Long id) {

        BorrowRecord borrowRecord = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found"));

        return borrowRecordMapper.toDTO(borrowRecord);
    }

    @Override
    public void delete(Long id) {

        borrowRecordRepository.deleteById(id);
    }

}