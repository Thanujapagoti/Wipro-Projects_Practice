package com.wipro.thanuja.borrowservice.controller;

import com.wipro.thanuja.borrowservice.entity.BorrowReturn;
import com.wipro.thanuja.borrowservice.service.BorrowReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class BorrowReturnController {
    private final BorrowReturnService borrowReturnService;

    @PostMapping("/borrow")
    public BorrowReturn borrowBook(
            @RequestParam Long userId,
            @RequestParam Long bookId) {
        return borrowReturnService.borrowBook(userId, bookId);
    }

    @PostMapping("/return/{transactionId}")
    public BorrowReturn returnBook(@PathVariable Long transactionId) {
        return borrowReturnService.returnBook(transactionId);
    }

    @GetMapping
    public List<BorrowReturn> getAllTransactions() {
        return borrowReturnService.getAllTransactions();
    }

    @GetMapping("/user/{userId}")
    public List<BorrowReturn> getTransactionsByUser(@PathVariable Long userId) {
        return borrowReturnService.getTransactionsByUser(userId);
    }

    @GetMapping("/status/{status}")
    public List<BorrowReturn> getTransactionsByStatus(@PathVariable String status) {
        return borrowReturnService.getTransactionsByStatus(status);
    }
}