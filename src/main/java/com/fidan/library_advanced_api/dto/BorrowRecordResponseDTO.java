package com.fidan.library_advanced_api.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRecordResponseDTO {

    private Long id;

    private String borrowerName;

    private String bookTitle;

    private LocalDate borrowDate;

}