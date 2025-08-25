package com.wipro.thanuja.borrowservice.entity;

import lombok.Data;

@Data
public class InventoryResponse {
    private Long id;
    private Long bookId;
    private int quantity;
    private boolean available;
}