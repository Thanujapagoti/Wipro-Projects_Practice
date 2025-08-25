package com.wipro.thanuja.borrowservice.feign;

//import com.wipro.thanuja.borrowservice.entity.InventoryResponse;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service")
public interface InventoryFeignClient {
    @GetMapping("/inventory/book/{bookId}")
    <InventoryResponse> InventoryResponse getInventoryByBookId(@PathVariable Long bookId);

    @PutMapping("/inventory/book/{bookId}/availability")
    void updateAvailability(@PathVariable Long bookId, @RequestParam boolean available);
}