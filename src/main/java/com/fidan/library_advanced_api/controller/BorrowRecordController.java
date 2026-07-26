package com.fidan.library_advanced_api.controller;

import com.fidan.library_advanced_api.dto.request.BorrowRecordRequestDTO;
import com.fidan.library_advanced_api.dto.response.BorrowRecordResponseDTO;
import com.fidan.library_advanced_api.service.BorrowRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow-records")
@RequiredArgsConstructor
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    @PostMapping
    public BorrowRecordResponseDTO create(@RequestBody BorrowRecordRequestDTO dto) {

        return borrowRecordService.create(dto);
    }

    @GetMapping
    public List<BorrowRecordResponseDTO> getAll() {

        return borrowRecordService.getAll();
    }

    @GetMapping("/{id}")
    public BorrowRecordResponseDTO getById(@PathVariable Long id) {

        return borrowRecordService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        borrowRecordService.delete(id);
    }

}