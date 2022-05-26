package com.cgi.commerceapp.service;


import com.cgi.commerceapp.model.Cart;
import com.cgi.commerceapp.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface CartService {

    List<Cart> getItemsInCart();
    void removeItem(Product product);
    Cart addItemToCart(Product product);

    void purchaseItems();
    double getCost();
}
