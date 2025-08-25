package com.wipro.thanuja.notificationservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PaymentEvent {
    private Long userId;
    private Long transactionId;
    private double amount;
    private String paymentType;
    private LocalDateTime paymentDate;
    
//    private String userEmail;
//    private String bookTitle;
}