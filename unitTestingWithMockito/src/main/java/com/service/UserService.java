package com.service;

import org.springframework.stereotype.Service;

import com.entity.Users;
import com.repository.UserRepo;

@Service
public class UserService {

	private final UserRepo userRepo;
	
	public UserService(UserRepo userRepo )
	{
		this.userRepo = userRepo;
	}
	
	public String getUserNameById(Long id)
	{
		return userRepo.findById(id).map(Users::getName).orElse("Unknown");
	}
}
