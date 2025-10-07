package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service 
public class LogService { 
 private static final Logger logger = 
LoggerFactory.getLogger(LogService.class);
 
 public void processData(String user) {
		logger.info("Processing started for users: {}", user);
 logger.debug("Debugging data flow for {}", user);
 logger.warn("This is just a warning for user {}", user);
 logger.error("Error example: Could not process {}", user);
 } 
} 
