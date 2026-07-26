package com.fidan.library_advanced_api.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRecordRequestDTO {

    private Long bookId;

    private String borrowerName;

    private LocalDate borrowDate;

}