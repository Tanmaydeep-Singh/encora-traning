package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String helloWorld()
	{
		return " Hello Spring Security";
	}
	
	@GetMapping("/user-dashboard")
	public String userDashboard()
	{
		return "Welcome User";
	}
	
	@GetMapping("/admin-dashboard")
	public String adminDashboard()
	{
		return "Welcome Admin";
	}
}
