package com.fidan.library_advanced_api.service;

import com.fidan.library_advanced_api.dto.request.BorrowRecordRequestDTO;
import com.fidan.library_advanced_api.dto.response.BorrowRecordResponseDTO;

import java.util.List;

public interface BorrowRecordService {

    BorrowRecordResponseDTO create(BorrowRecordRequestDTO dto);

    List<BorrowRecordResponseDTO> getAll();

    BorrowRecordResponseDTO getById(Long id);

    void delete(Long id);

}