package com.strutsShoppingProject.component;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.strutsShoppingProject.model.Users;
import com.strutsShoppingProject.repository.UserRepo;
import com.strutsShoppingProject.service.BillServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("bill")
public class Bill extends Action {
	
	@Autowired
	BillServiceImpl billServiceImpl;
	
	@Autowired
	UserRepo usersRepo;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Users user = usersRepo.findByUsernameAndPassword("1","1");
		
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
		
		List<String> items = new ArrayList<>();  // ✅ initialize list
  
		while (e.hasMoreElements()) {
			
            String name = e.nextElement();
			System.out.println("ITEM " + name );

            Object value = session.getAttribute(name);
			System.out.println("Value " + value.toString());
			if(name != "uid")
			{
	            items.add(value.toString());
			}
        }
		
		com.strutsShoppingProject.model.Bill billdetails =  billServiceImpl.generateBill(items,user);
		request.setAttribute("billdetails", billdetails);
		
		return "bill.success";
	}

}
