package com.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public CompletableFuture<String> sendEmailAsync(String email) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                return "Email sent to " + email;
            } catch (Exception e) {
                throw new IllegalStateException("Error sending mail", e);
            }
        });
    }
}
