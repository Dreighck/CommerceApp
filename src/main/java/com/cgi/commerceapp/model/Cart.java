package com.cgi.commerceapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    private String name;
    private double price;

    public Cart() {
    }

    public Cart(Long orderNumber, String name, double price) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return orderNumber;
    }

    public void setId(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
