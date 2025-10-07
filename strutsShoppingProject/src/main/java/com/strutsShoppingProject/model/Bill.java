package com.strutsShoppingProject.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

@Entity
public class Bill implements Serializable, Comparable<Bill> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date billDate;
    
    private Integer totalCost;
    
    public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	@ManyToOne
    private Users user;
    
    private List<String> items ;


    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Bill o) {
        return this.billDate.compareTo(o.billDate);
    }
}
