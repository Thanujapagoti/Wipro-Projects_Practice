package com.wipro.thanuja.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceLibApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookServiceLibApplication.class, args);
    }
}