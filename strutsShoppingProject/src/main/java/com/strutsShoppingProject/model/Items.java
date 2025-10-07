package com.strutsShoppingProject.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Items implements Serializable, Comparable<Items> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    // renamed from "desc" → "description"
    private String description;

    private Integer price;

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // Proper compareTo (sort by price, then name)
    @Override
    public int compareTo(Items o) {
        int priceCompare = this.price.compareTo(o.price);
        if (priceCompare != 0) {
            return priceCompare;
        }
        return this.name.compareTo(o.name);
    }

    // equals & hashCode (based on id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items)) return false;
        Items items = (Items) o;
        return Objects.equals(id, items.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
