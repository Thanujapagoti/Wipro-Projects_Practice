package com.wipro.thanuja.paymentservice.controller;

import com.wipro.thanuja.paymentservice.entity.Payment;
import com.wipro.thanuja.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/fine")
    public Payment createFine(
            @RequestParam Long transactionId,
            @RequestParam String paymentMethod) {
        return paymentService.createFine(transactionId, paymentMethod);
    }

    @PostMapping("/{paymentId}/pay")
    public Payment markAsPaid(@PathVariable Long paymentId) {
        return paymentService.markAsPaid(paymentId);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUser(@PathVariable Long userId) {
        return paymentService.getPaymentsByUser(userId);
    }

    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        return paymentService.getPaymentsByStatus(status);
    }
}