package com.fidan.library_advanced_api.dto.request;

import lombok.Data;

@Data
public class BorrowRecordRequestDTO {

    private Long bookId;

    private String borrowerName;

}