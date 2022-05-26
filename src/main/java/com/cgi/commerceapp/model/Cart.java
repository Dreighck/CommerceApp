package com.cgi.commerceapp.model;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemNumber;
//    private String name;
//    private double price;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "product")
    private Product product;
    public Cart() {
    }

    public Cart(Product product){
        super();
        this.product=product;
//        this.name= product.getName();
//        this.price=product.getPrice();
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
//        this.name= product.getName();
//        this.price=product.getPrice();
    }
    public Cart(Product product, Long itemNumber) {
        super();
        this.itemNumber = itemNumber;
        this.product = product;
//        this.name= product.getName();
//        this.price=product.getPrice();
    }

//    public String getName() {
//        return name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
    public Long getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Long orderNumber) {
        this.itemNumber = orderNumber;
    }
}
