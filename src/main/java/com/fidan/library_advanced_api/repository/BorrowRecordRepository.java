package com.fidan.library_advanced_api.repository;

import com.fidan.library_advanced_api.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}