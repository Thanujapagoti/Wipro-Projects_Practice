package com.wipro.thanuja.inventoryservice.controller;

import com.wipro.thanuja.inventoryservice.entity.Inventory;
import com.wipro.thanuja.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/book/{bookId}")
    public Inventory getInventoryByBookId(@PathVariable Long bookId) {
        return inventoryService.getInventoryByBookId(bookId);
    }

    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
    }
}