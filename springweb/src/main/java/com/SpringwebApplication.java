package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringwebApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx =
		SpringApplication.run(SpringwebApplication.class, args);
	
		
	}

}
