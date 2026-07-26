package com.fidan.library_advanced_api.mapper;

import com.fidan.library_advanced_api.dto.response.BorrowRecordResponseDTO;
import com.fidan.library_advanced_api.entity.BorrowRecord;
import org.springframework.stereotype.Component;

@Component
public class BorrowRecordMapper {

    public BorrowRecordResponseDTO toResponse(BorrowRecord record) {

        BorrowRecordResponseDTO dto = new BorrowRecordResponseDTO();

        dto.setId(record.getId());
        dto.setBorrowerName(record.getBorrowerName());
        dto.setBorrowDate(record.getBorrowDate());

        if (record.getBook() != null) {
            dto.setBookTitle(record.getBook().getTitle());
        }

        return dto;
    }
}