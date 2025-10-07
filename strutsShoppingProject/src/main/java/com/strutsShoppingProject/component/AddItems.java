package com.strutsShoppingProject.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.strutsShoppingProject.service.ItemsService;
import com.strutsShoppingProject.service.ItemsServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component("addItems")
public class AddItems extends Action{

	@Autowired
	ItemsServiceImpl itemsServiceImpl;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CALLED");

		
		String name = request.getParameter("itemName");
		int price = Integer.parseInt(request.getParameter("itemPrice"));
		System.out.println("CALLED" + name + price);

	
			itemsServiceImpl.createShopItems(name, price);	
		
		
		return "addItems";
	}
	

}
