package com.fidan.library_advanced_api.service;

import com.fidan.library_advanced_api.entity.BorrowRecord;

public interface BorrowRecordService {

    BorrowRecord borrowBook(Long bookId, String borrowerName);

}