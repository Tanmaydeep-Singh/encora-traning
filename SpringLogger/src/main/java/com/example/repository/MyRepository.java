package com.example.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
	
	public List<String> getGreetings() {
		 return List.of("Hi", "Hello", "Welcome");
		 } 

}
