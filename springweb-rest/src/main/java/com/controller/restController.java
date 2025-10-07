package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;

@RestController
@RequestMapping("/v1")
public class restController {

	
	@GetMapping("/")
	public void hello()
	{
		System.out.println("Hello REST CONTROLLER");
	}
	
	@GetMapping("/hello")
	public String helloUser()
	{	
		return "{ name : tanmay }";
	}
	
	@GetMapping("/hello3")
	public ResponseEntity<String> sayHello3() {
        return ResponseEntity.ok("hai and welcome to spring mvc");
    } 
	
	@PostMapping("/create")
	public ResponseEntity<User> sayHello11(@RequestBody User user) {
//		User user=new User();
//		user.setUid(100+user.get());
//		user.setUname("ramu"+user.getUname());
		user.setName("new name " + user.getName());
        return ResponseEntity.ok(user);
    }
	
	
	
	
	@GetMapping("/user")
	public User getUser()
	{
		User newUser = new User();
		newUser.setName("tanamy");
		newUser.setAmount(1000);
		newUser.setDepartment("cse");
		
		return newUser;
	}
	
	
	
}
