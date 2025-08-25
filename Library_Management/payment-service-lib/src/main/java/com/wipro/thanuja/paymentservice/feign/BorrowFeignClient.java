package com.wipro.thanuja.paymentservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//
//import com.wipro.thanuja.paymentservice.entity.BorrowTransactionResponse;

@FeignClient(name = "borrow-service")
public interface BorrowFeignClient {
    @GetMapping("/transactions/{id}")
    <BorrowTransactionResponse> BorrowTransactionResponse getTransactionById(@PathVariable Long id);
}