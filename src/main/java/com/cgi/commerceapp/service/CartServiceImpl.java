package com.cgi.commerceapp.service;


import com.cgi.commerceapp.model.Cart;
import com.cgi.commerceapp.model.Product;
import com.cgi.commerceapp.repo.CartRepo;
import com.cgi.commerceapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepo cartRepo;
    ProductRepo productRepo;

    @Override
    public Iterable<Product> getItemsInCart() {
      return cartRepo.findAll();
    }

    @Override
    public void removeItem(Long id) {
        cartRepo.deleteById(id);
    }

    @Override
    public Product addItemToCart(Product product) {
        return cartRepo.save(product);
    }

    @Override
    public void purchaseItems(){
        Iterable<Product> products = getItemsInCart();
        cartRepo.delete(products.iterator().next());
    }
}
