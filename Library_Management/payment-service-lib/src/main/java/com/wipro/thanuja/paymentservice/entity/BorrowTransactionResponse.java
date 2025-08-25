package com.wipro.thanuja.paymentservice.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowTransactionResponse {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private String status;
}