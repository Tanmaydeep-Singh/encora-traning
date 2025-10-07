package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping
    public List<Product> getAllProducts() {
		return productRepository.findAll();
        
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
		return productRepository.findById(id).get();

    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
		Product newProduct = new Product();
		newProduct = productRepository.save(product); 
    	return newProduct;

    }
    
    @GetMapping("/createsampleproduct")
    public Product createSampleProduct() {
    	Product newProduct = new Product();
    	
		newProduct.setName("Sample Product");
		newProduct.setPrice(0.0);
		productRepository.save(newProduct); 
		return newProduct;

    }
    
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    	Product product = productRepository.findById(id).get();
    	product.setName(productDetails.getName());
    	product.setPrice(productDetails.getPrice());
    	productRepository.save(product);
    	return product;

    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
    	productRepository.delete(productRepository.findById(id).get());
    }
}