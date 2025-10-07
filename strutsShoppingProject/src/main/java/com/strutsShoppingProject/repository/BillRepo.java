package com.strutsShoppingProject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.strutsShoppingProject.model.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, UUID> {
}
