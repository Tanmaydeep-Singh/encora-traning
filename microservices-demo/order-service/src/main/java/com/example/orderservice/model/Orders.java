package com.example.orderservice.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thoughtworks.xstream.converters.time.LocalDateTimeConverter;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO )
	private long id;
	private LocalDateTime date = LocalDateTime.now();	

}
