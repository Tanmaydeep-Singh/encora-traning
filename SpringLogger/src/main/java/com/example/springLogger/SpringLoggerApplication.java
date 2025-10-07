package com.example.springLogger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.service.MyService;


//TRACE (most detailed) 
//DEBUG
//INFO
//WARN
//ERROR
//OFF 

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class SpringLoggerApplication  implements CommandLineRunner {
	
	private MyService myService;
	
	
	public SpringLoggerApplication(MyService myService) {
		this.myService = myService;
	}

	public static void main(String[] args) {
       SpringApplication.run(SpringLoggerApplication.class, args);
		System.out.println("Running...");
	}

	@Override
	public void run(String... args) throws Exception {
		myService.myServiceTest();
		
	}
	

	
	
	
}
