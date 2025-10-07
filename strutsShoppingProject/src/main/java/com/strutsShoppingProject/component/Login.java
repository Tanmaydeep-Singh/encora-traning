package com.strutsShoppingProject.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.strutsShoppingProject.model.Users;
import com.strutsShoppingProject.service.LoginServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component("login")
public class Login extends Action{
	
	
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("CALLED");
	String username = request.getParameter("uname");
	String password = request.getParameter("upass");
	Users currentUser = loginServiceImpl.login(username, password);
	
	if(currentUser != null)
	{
		 request.getSession().setAttribute("uid",currentUser.getId() );
		return "login.success";

	}
	return "login.failure";
}
}
