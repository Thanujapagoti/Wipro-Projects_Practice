package com.wipro.thanuja.notificationservice.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookReturnedEvent {
    private Long userId;
    private Long bookId;
    private LocalDate returnDate;
}