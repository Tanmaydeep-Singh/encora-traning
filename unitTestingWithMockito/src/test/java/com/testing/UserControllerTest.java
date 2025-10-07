package com.testing;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.controller.UserController;
import com.entity.Users;
import com.repository.UserRepo;

import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepo userRepo;
	
	@Test
	void shouldReturnUser_whenExists() throws Exception {
		  PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
	        Timer timer = registry.timer("application.process.time");  


	        timer.record(() -> {
		 Users user = new Users(1L, "Tanmay");
	     when(userRepo.findById(1L)).thenReturn(Optional.of(user));

        try {
			mockMvc.perform(get("/users/" + user.getId()))
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$.id").value(user.getId()))
			        .andExpect(jsonPath("$.name").value("Tanmay"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	        });
	        
	        System.out.println(registry.scrape());
	}
}
