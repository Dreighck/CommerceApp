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
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity;
        responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/products")
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
    @PutMapping("/products/")
    public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws ProductWithTheIDDoesntExistException, ProductWithTheIDAlreadyExistsException {
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @DeleteMapping("/products/")
    public ResponseEntity<?> deleteProductHandler(@PathVariable("prodId") int id) throws ProductWithTheIDDoesntExistException {
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
