package com.fidan.library_advanced_api.controller;

import com.fidan.library_advanced_api.entity.BorrowRecord;
import com.fidan.library_advanced_api.service.BorrowRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    @PostMapping
    public BorrowRecord borrowBook(@RequestParam Long bookId,
                                   @RequestParam String borrowerName) {

        return borrowRecordService.borrowBook(bookId, borrowerName);
    }
}