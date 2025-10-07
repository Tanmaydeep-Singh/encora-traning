package com.strutsShoppingProject.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strutsShoppingProject.model.Users;
import com.strutsShoppingProject.repository.UserRepo;

@Service
public class LogoutServiceImpl implements LogoutService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public void Logout(UUID userId) {
	
		Users user = userRepo.findById(userId).orElse(null);

	    if (user == null) {
	        System.out.println("User with ID " + userId + " not found!");
	        return;
	    }
	    
	    user.setFlag(false);
	    
	    userRepo.save(user);

	    System.out.println("User " + user.getUsername() + " logged out successfully."+" USER FLAG: " + user.isFlag() );	}

}
