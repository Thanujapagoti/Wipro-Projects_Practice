package com.wipro.thanuja.borrowservice.service;

import com.wipro.thanuja.borrowservice.entity.BorrowReturn;
import com.wipro.thanuja.borrowservice.entity.InventoryResponse;
import com.wipro.thanuja.borrowservice.feign.InventoryFeignClient;
import com.wipro.thanuja.borrowservice.repository.BorrowReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowReturnService {
    private final BorrowReturnRepository borrowReturnRepository;
    private final InventoryFeignClient inventoryFeignClient;

    @Transactional
    public BorrowReturn borrowBook(Long userId, Long bookId) {
        // Check inventory availability
        InventoryResponse inventory = inventoryFeignClient.getInventoryByBookId(bookId);
        if (inventory == null || !inventory.isAvailable() || inventory.getQuantity() <= 0) {
            throw new RuntimeException("Book not available for borrowing");
        }

        // Update inventory
        inventoryFeignClient.updateAvailability(bookId, false);

        // Create borrow record
        BorrowReturn transaction = new BorrowReturn();
        transaction.setUserId(userId);
        transaction.setBookId(bookId);
        transaction.setBorrowDate(LocalDate.now());
        transaction.setDueDate(LocalDate.now().plusWeeks(2));
        transaction.setStatus("BORROWED");

        return borrowReturnRepository.save(transaction);
    }

    @Transactional
    public BorrowReturn returnBook(Long transactionId) {
        BorrowReturn transaction = borrowReturnRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        // Update inventory
        inventoryFeignClient.updateAvailability(transaction.getBookId(), true);

        // Update transaction
        transaction.setReturnDate(LocalDate.now());
        transaction.setStatus("RETURNED");

        return borrowReturnRepository.save(transaction);
    }

    public List<BorrowReturn> getAllTransactions() {
        return borrowReturnRepository.findAll();
    }

    public List<BorrowReturn> getTransactionsByUser(Long userId) {
        return borrowReturnRepository.findByUserId(userId);
    }

    public List<BorrowReturn> getTransactionsByStatus(String status) {
        return borrowReturnRepository.findByStatus(status);
    }
}