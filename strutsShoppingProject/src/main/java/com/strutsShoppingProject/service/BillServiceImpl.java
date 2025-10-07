package com.strutsShoppingProject.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strutsShoppingProject.model.Bill;
import com.strutsShoppingProject.model.Items;
import com.strutsShoppingProject.model.Users;
import com.strutsShoppingProject.repository.BillRepo;
import com.strutsShoppingProject.repository.ItemsRepo;

@Service
public class BillServiceImpl implements BillingService {
    
    @Autowired
    private ItemsRepo itemsRepo;

    @Autowired
    private BillRepo billRepo;

    @Override
    public Bill generateBill(List<String> itemNames, Users user) {
        int totalCost = 0;
        List<Items> selectedItems = new ArrayList<>();

        for (String itemName : itemNames) {
            Items currentItem = itemsRepo.findByName(itemName);
            if (currentItem != null) {
                selectedItems.add(currentItem);
                totalCost += currentItem.getPrice();
            }
        }

        // Create and save Bill
        Bill bill = new Bill();
        bill.setBillDate(Date.valueOf(LocalDate.now()));
        bill.setUser(user);
        bill.setItems(itemNames);
        bill.setTotalCost(totalCost);

        billRepo.save(bill);

       
        System.out.println("Bill generated for user: " + user.getUsername());
        System.out.println("TOTAL COST: " + totalCost);
        return bill;
    }
}
