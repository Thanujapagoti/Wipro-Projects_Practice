package com.wipro.thanuja.paymentservice.repository;

import com.wipro.thanuja.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(Long userId);
    List<Payment> findByStatus(String status);
    List<Payment> findByTransactionId(Long transactionId);
}