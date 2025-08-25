package com.wipro.thanuja.borrowservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class BorrowReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    private String status; 
}