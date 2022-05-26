package com.cgi.commerceapp.controller;


import com.cgi.commerceapp.exceptions.ProductWithTheIDAlreadyExistsException;
import com.cgi.commerceapp.exceptions.ProductWithTheIDDoesntExistException;
import com.cgi.commerceapp.model.Product;
import com.cgi.commerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired ProductService productService;

    @GetMapping(value = {"/",""})
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity;
        responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping(value = {"/{prodID}"})
    public ResponseEntity<Product> getProduct(@PathVariable ("prodID") int prodID) throws ProductWithTheIDDoesntExistException {
        Product product = productService.getProductById(prodID);
        ResponseEntity<Product> responseEntity;
        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping({"/",""})
    public ResponseEntity<?> addProductHandler(@RequestBody Product product){
        ResponseEntity<?> responseEntity;
        try {
            Product prod=new Product();
            prod = productService.addNewProduct(product);
            responseEntity = new ResponseEntity<>(prod, HttpStatus.CREATED);
        }catch (ProductWithTheIDAlreadyExistsException e){
            responseEntity = new ResponseEntity<>("Failed to store, Duplicate",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping({"/",""})
    public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws ProductWithTheIDDoesntExistException, ProductWithTheIDAlreadyExistsException {
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @DeleteMapping("/{prodId}")
    public ResponseEntity<?> deleteProductHandler(@PathVariable("prodId") int id) throws ProductWithTheIDDoesntExistException {
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
