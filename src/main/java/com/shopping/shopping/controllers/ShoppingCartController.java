package com.shopping.shopping.controllers;

import com.shopping.shopping.entities.Customer;
import com.shopping.shopping.entities.ItemToPurchase;
import com.shopping.shopping.entities.Product;
import com.shopping.shopping.entities.ShoppingCart;
import com.shopping.shopping.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ShoppingCartController {

//    @Autowired ShoppingCartService shoppingCartService;
//    @Autowired Product product;
//    @Autowired ItemToPurchase itemToPurchase;

    @PostMapping(path="addProduct", consumes = "application/JSON")
    public ResponseEntity<ShoppingCart> addToCart(@RequestParam Customer customer, @RequestParam ItemToPurchase itemToPurchase, @RequestParam Product product){
        // Assign product to item
        //Assign item purchase to a cart
        // Assign cart to customer
        return null;
    }

    public void deleteProductToCart(){}

    public void showCartByUser(){}
}
