package com.strutsShoppingProject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.strutsShoppingProject.model.Items;
import com.strutsShoppingProject.model.Users;

@Repository
public interface ItemsRepo extends JpaRepository<Items, UUID> {
		
	public Items findByName(String item);

}
