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
    public List<Cart> getItemsInCart() {
      return cartRepo.findAll();
    }

    @Override
    public void removeItem(Product product) {
        cartRepo.deleteById(product);
    }

    @Override
    public Cart addItemToCart(Product product) {
        return cartRepo.save(new Cart(product));
    }

    @Override
    public void purchaseItems(){
        for (Cart item: getItemsInCart()) {
            productRepo.deleteById(item.getProduct().getId());
        }
        cartRepo.deleteAll();
    }

    @Override
    public double getCost() {
        double cost =0;
        for(Cart item : getItemsInCart()){
            cost+=item.getProduct().getPrice();
        }
        return cost;
    }


}
