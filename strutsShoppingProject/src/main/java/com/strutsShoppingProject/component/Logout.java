package com.strutsShoppingProject.component;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.strutsShoppingProject.service.LogoutServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("logout")
public class Logout extends Action {
	
	@Autowired
	LogoutServiceImpl logoutServiceImpl;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		UUID uid =(UUID)session.getAttribute("uid");
		session.removeAttribute("uid");
		logoutServiceImpl.Logout(uid);

		return "logout";
	}
}