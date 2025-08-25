// BookBorrowedEvent.java
package com.wipro.thanuja.notificationservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookBorrowedEvent {
    private Long userId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
}