package com.wipro.thanuja.notificationservice.service;

import com.wipro.thanuja.notificationservice.dto.BookBorrowedEvent;
import com.wipro.thanuja.notificationservice.dto.BookReturnedEvent;
import com.wipro.thanuja.notificationservice.dto.PaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @KafkaListener(topics = "${notification.topic.book-borrowed}", groupId = "${spring.kafka.consumer.group-id}")
    public void handleBookBorrowedEvent(BookBorrowedEvent event) {
        log.info("Received Book Borrowed Event for user {}: Book {} borrowed on {}, due on {}",
                event.getUserId(),
                event.getBookId(),
                event.getBorrowDate(),
                event.getDueDate());
        
 
    }

    @KafkaListener(topics = "${notification.topic.book-returned}", groupId = "${spring.kafka.consumer.group-id}")
    public void handleBookReturnedEvent(BookReturnedEvent event) {
        log.info("Received Book Returned Event for user {}: Book {} returned on {}",
                event.getUserId(),
                event.getBookId(),
                event.getReturnDate());
    }

    @KafkaListener(topics = "${notification.topic.payment-made}", groupId = "${spring.kafka.consumer.group-id}")
    public void handlePaymentEvent(PaymentEvent event) {
        log.info("Received Payment Event for user {}: Amount {} paid for {} on {}",
                event.getUserId(),
                event.getAmount(),
                event.getPaymentType(),
                event.getPaymentDate());
    }
}