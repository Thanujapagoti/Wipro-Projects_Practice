package com.wipro.thanuja.paymentservice.service;

import com.wipro.thanuja.paymentservice.entity.BorrowTransactionResponse;
import com.wipro.thanuja.paymentservice.entity.Payment;
import com.wipro.thanuja.paymentservice.feign.BorrowFeignClient;
import com.wipro.thanuja.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final BorrowFeignClient borrowFeignClient;

    private static final double DAILY_FINE_RATE = 10.0;

    @Transactional
    public Payment createFine(Long transactionId, String paymentMethod) {
        // Get transaction details from Borrow Service
        BorrowTransactionResponse transaction = borrowFeignClient.getTransactionById(transactionId);
        
        if (transaction == null) {
            throw new RuntimeException("Transaction not found");
        }

        // Calculate fine if overdue
        double fineAmount = 0.0;
        if ("BORROWED".equals(transaction.getStatus())) {
            if (LocalDate.now().isAfter(transaction.getDueDate())) {
                long daysOverdue = LocalDate.now().toEpochDay() - transaction.getDueDate().toEpochDay();
                fineAmount = daysOverdue * DAILY_FINE_RATE;
            }
        }

        // Create payment record
        Payment payment = new Payment();
        payment.setUserId(transaction.getUserId());
        payment.setTransactionId(transactionId);
        payment.setAmount(fineAmount);
        payment.setPaymentType("FINE");
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus(fineAmount > 0 ? "PENDING" : "COMPLETED");
        payment.setPaymentMethod(paymentMethod);

        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment markAsPaid(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        
        payment.setStatus("COMPLETED");
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public List<Payment> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepository.findByStatus(status);
    }
}