package com.cgi.commerceapp.controller;

import com.cgi.commerceapp.exceptions.ProductWithTheIDAlreadyExistsException;
import com.cgi.commerceapp.model.Product;
import com.cgi.commerceapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

   @Autowired
   CartService cartService;

    @GetMapping(value={"/",""})
    public ResponseEntity<List<Product>> getAllItems(){
        List<Product> items = cartService.getItemsInCart();
        ResponseEntity<List<Product>> responseEntity;
        responseEntity=new ResponseEntity<>(items, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(value={"/",""})
    public ResponseEntity<?> addToCartHandler(@RequestBody Product product){
        ResponseEntity<?> responseEntity;
        try {
            Product prod;
            prod = cartService.addItemToCart(product);
            responseEntity = new ResponseEntity<>(prod, HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>("Failed to store, Duplicate",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
