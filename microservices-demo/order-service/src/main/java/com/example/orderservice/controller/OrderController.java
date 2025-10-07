package com.example.orderservice.controller;

import com.example.orderservice.client.ProductServiceClient;
import com.example.orderservice.model.Orders;
import com.example.orderservice.repository.OrderRepository;
import com.thoughtworks.xstream.converters.time.LocalDateTimeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductServiceClient productServiceClient;
    
   
    
    @GetMapping
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
    
    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
       return orderRepository.save(order);
    }
    @GetMapping("/createorder")
    public Orders createSampleOrder() {
    	Orders order = new Orders();
    	return orderRepository.save(order);

    }
    
    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
return orderRepository.findById(id).get();
    }
    
    
//    Feing 
    @GetMapping("/product/{productId}")
    public Object getProductInfo(@PathVariable Long productId)
    {
    	System.out.println("called");
    	return productServiceClient.getProductById(productId);
    }
    
  
}