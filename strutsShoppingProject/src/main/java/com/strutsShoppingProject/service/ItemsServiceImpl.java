package com.strutsShoppingProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strutsShoppingProject.model.Items;
import com.strutsShoppingProject.repository.ItemsRepo;

@Service
public class ItemsServiceImpl  implements ItemsService{

	@Autowired
	ItemsRepo itemsRepo;
	
	@Override
	public void createShopItems(String name, int price) {
		
		Items newItem = new Items();
		
		newItem.setName(name);
		newItem.setDescription(name);
		newItem.setPrice(price);
		
		itemsRepo.save(newItem);
	}

}
