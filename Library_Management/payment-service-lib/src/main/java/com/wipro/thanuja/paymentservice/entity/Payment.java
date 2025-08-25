package com.wipro.thanuja.paymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private Long transactionId; // Links to borrow/return transaction
    private double amount;
    private String paymentType; // FINE, MEMBERSHIP, etc.
    private LocalDateTime paymentDate;
    private String status; // PENDING, COMPLETED, FAILED
    private String paymentMethod; // CARD, CASH, etc.
}