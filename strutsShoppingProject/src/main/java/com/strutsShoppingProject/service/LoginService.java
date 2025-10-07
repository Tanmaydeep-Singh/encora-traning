package com.strutsShoppingProject.service;

import com.strutsShoppingProject.model.Users;

public interface LoginService {
	
	public Users login(String username, String password);
	public Users create(String username, String password);
}
