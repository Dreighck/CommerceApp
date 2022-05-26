package com.cgi.commerceapp.service;


import com.cgi.commerceapp.model.Cart;
import com.cgi.commerceapp.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface CartService {

    Iterable<Product> getItemsInCart();
    void removeItem(Long id);
    Product addItemToCart(Product product);

    void purchaseItems();
}
