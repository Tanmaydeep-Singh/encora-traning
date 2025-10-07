package com.strutsShoppingProject.service;

import java.util.List;

import com.strutsShoppingProject.model.Bill;
import com.strutsShoppingProject.model.Users;

public interface BillingService {

	public Bill generateBill(List<String> items,Users user);
	
}
