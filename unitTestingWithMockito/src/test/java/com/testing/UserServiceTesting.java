package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entity.Users;
import com.repository.UserRepo;
import com.service.UserService;

import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

@ExtendWith(MockitoExtension.class)
public class UserServiceTesting {

    @Mock
    private UserRepo userRepo;
    
    @InjectMocks
    private UserService userService;
    
    @Test
    void shouldReturnUserName_whenUserExists() {
        PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        Timer timer = registry.timer("application.process.time");  


        timer.record(() -> {
            Users user = new Users(1L, "Tanmay");
            when(userRepo.findById(1L)).thenReturn(Optional.of(user));

            String res = userService.getUserNameById(1L);

            assertEquals("Tanmay", res);
            verify(userRepo).findById(1L);
        });
        
        System.out.println(registry.scrape());
    }
    
    @Test
    void shouldReturnUnknown_whenUserDoesNotExists() {
        PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        Timer timer = registry.timer("application.process.time");  


        timer.record(() -> {
    	when(userRepo.findById(2L)).thenReturn(Optional.empty());

        String res = userService.getUserNameById(2L);

        assertEquals("Unknown", res);
 });
        
        System.out.println(registry.scrape());

    }
}
