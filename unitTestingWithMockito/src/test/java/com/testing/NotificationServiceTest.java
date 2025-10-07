package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.service.NotificationService;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    private NotificationService service = new NotificationService();

    @Test
    void shouldSendEmailAsyncSuccessfully() throws Exception {
        CompletableFuture<String> future = service.sendEmailAsync("test@gmail.com");

        String res = future.get(6, TimeUnit.SECONDS);

        assertEquals("Email sent to test@gmail.com", res);
    }
}
