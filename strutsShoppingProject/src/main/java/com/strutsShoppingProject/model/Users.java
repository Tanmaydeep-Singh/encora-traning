package com.strutsShoppingProject.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users implements Serializable, Comparable<Users> {

	@Id
	@GeneratedValue( strategy =  GenerationType.UUID)
	private UUID id;
	private String username;
	private String password;
	
	private boolean flag;
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(id, other.id);
	}





	public UUID getId() {
		return id;
	}





	public void setId(UUID id) {
		this.id = id;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public boolean isFlag() {
		return flag;
	}





	public void setFlag(boolean flag) {
		this.flag = flag;
	}





	@Override
	public int compareTo(Users o) {
		return this.id.compareTo(o.id);
	}
	
	
	
}
