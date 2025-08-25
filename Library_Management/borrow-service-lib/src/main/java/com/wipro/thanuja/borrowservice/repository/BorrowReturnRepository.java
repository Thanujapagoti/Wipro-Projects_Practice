package com.wipro.thanuja.borrowservice.repository;

import com.wipro.thanuja.borrowservice.entity.BorrowReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowReturnRepository extends JpaRepository<BorrowReturn, Long> {
    List<BorrowReturn> findByBookId(Long bookId);
    List<BorrowReturn> findByUserId(Long userId);
    List<BorrowReturn> findByStatus(String status);
}