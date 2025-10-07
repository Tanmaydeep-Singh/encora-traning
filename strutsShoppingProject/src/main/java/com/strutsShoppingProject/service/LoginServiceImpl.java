package com.strutsShoppingProject.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strutsShoppingProject.model.Users;
import com.strutsShoppingProject.repository.UserRepo;

@Service
public class LoginServiceImpl  implements LoginService{
	Users user = null;
	@Autowired
	UserRepo userRepo;
	
	@Override
	public Users login(String username, String password) {
		
		Users currentUser = userRepo.findByUsernameAndPassword(username, password);

		if(currentUser != null)
		{
			currentUser.setFlag(true);
			userRepo.save(currentUser);
		}

		return currentUser;
		
	}

	@Override
	public Users create(String username, String password) {
		user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setFlag(false);
		user = userRepo.save(user);
		return user;
	}

	
	
}
