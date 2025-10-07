package com.strutsShoppingProject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.strutsShoppingProject.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, UUID> {
	
	public Users findByUsernameAndPassword(String username, String password);

}
