package com.cgi.commerceapp.model;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    @Transient
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart() {
    }

    public Cart(Product product){
        this.product=product;
    }

    public Cart(Long orderNumber, Product product) {
        this.orderNumber = orderNumber;
        this.product = product;
    }

    public Long getId() {
        return orderNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
