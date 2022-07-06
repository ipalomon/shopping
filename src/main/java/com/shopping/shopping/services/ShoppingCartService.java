package com.shopping.shopping.services;

import com.shopping.shopping.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    public void addToCart(long userId){}
}
