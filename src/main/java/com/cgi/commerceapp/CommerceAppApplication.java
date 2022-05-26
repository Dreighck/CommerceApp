package com.cgi.commerceapp;

import com.cgi.commerceapp.model.Product;
import com.cgi.commerceapp.service.CartService;
import com.cgi.commerceapp.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommerceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommerceAppApplication.class, args);
    }

    @Bean
    CommandLineRunner prodRunner(ProductService productService) {
        return args -> {
            productService.addNewProduct(new Product( "TV Set", 300.00, "Samsung"));
            productService.addNewProduct(new Product("Game Console", 200.00));
            productService.addNewProduct(new Product( "Sofa", 100.00));
            productService.addNewProduct(new Product( "Icecream", 5.00));
            productService.addNewProduct(new Product( "Beer", 3.00));
            productService.addNewProduct(new Product( "Phone", 500.00, "iPhone"));
            productService.addNewProduct(new Product( "Watch", 30.00));
        };
    }
    @Bean CommandLineRunner cartRunner(CartService cartService) {
        return args -> {
            cartService.addItemToCart(new Product("TV", 250.03 ));
            cartService.addItemToCart(new Product( "Phone", 1500.00));
        };
    }
}
