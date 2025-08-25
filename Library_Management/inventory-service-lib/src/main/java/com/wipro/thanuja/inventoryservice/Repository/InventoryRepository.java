package com.wipro.thanuja.inventoryservice.Repository;


import com.wipro.thanuja.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByBookId(Long bookId);
}