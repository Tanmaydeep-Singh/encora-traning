package com.strutsShoppingProject.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.strutsShoppingProject.service.LoginServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("register")
public class Register extends Action {

	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("uname");
		String password = request.getParameter("upass");
		
       loginServiceImpl.create(username, password);
		
		return "login.success";
		
	}

}
