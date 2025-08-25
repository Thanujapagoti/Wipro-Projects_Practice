package com.wipro.thanuja.inventoryservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.thanuja.inventoryservice.Repository.InventoryRepository;
import com.wipro.thanuja.inventoryservice.entity.Inventory;

import lombok.RequiredArgsConstructor;

@Service


@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryByBookId(Long bookId) {
        return inventoryRepository.findByBookId(bookId);
    }

    public Inventory updateInventory(Long id, Inventory inventory) {
        if (inventoryRepository.existsById(id)) {
            inventory.setId(id);
            return inventoryRepository.save(inventory);
        }
        return null;
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}