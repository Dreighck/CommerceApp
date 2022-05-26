package com.cgi.commerceapp;

import com.cgi.commerceapp.model.Product;
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
}
