package com.shopping.shopping.services;

import com.shopping.shopping.entities.Customer;
import com.shopping.shopping.entities.ItemToPurchase;
import com.shopping.shopping.entities.Product;
import com.shopping.shopping.entities.ShoppingCart;
import com.shopping.shopping.repositories.CustomerRepository;
import com.shopping.shopping.repositories.ItemToPurchaseRepository;
import com.shopping.shopping.repositories.ProductRepository;
import com.shopping.shopping.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ItemToPurchaseRepository itemToPurchaseRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    CustomerRepository customerRepository;
    public boolean assignProductToItem(ItemToPurchase itemToPurchase, Product currentProduct, Customer customer){
        // Assign product to item
        Optional<Product> product = this.findProductById(currentProduct.getProductId());
        ItemToPurchase itemToPurchase1 = new ItemToPurchase(itemToPurchase.getQuantity(),itemToPurchase.getPricePerUnit());
        ItemToPurchase it1 = itemToPurchaseRepository.save(itemToPurchase1);

        // product.ifPresent(itemToPurchase1::setProduct);
        if(product.isPresent()){
            itemToPurchaseRepository.save(itemToPurchase1);
        }
        else{
            return false;
        }

        // Assign item to cart
        double totalMoney = itemToPurchase1.getQuantity()*itemToPurchase1.getPricePerUnit();
        ShoppingCart soppingCart1 = new ShoppingCart(itemToPurchase1.getPricePerUnit(),21, totalMoney);
        ShoppingCart spc1 = shoppingCartRepository.save(soppingCart1);
        soppingCart1.getItemToPurchases().add(itemToPurchase1);
        shoppingCartRepository.save(soppingCart1);
        itemToPurchase1.getShoppingCarts().add(soppingCart1);
        itemToPurchaseRepository.save(itemToPurchase1);

        // Assign cart to customer
        Optional<Customer> currentCustomer = this.findCustomerById(customer.getCustomerId());

        if(!currentCustomer.isPresent()){
            return false;
        }
        soppingCart1.setCustomerToPurchase(currentCustomer.get());
        shoppingCartRepository.save(soppingCart1);

        return true;
    }

    public Optional<Product> findProductById(long productId){
        return productRepository.findById(productId);
    }

    public Optional<Customer> findCustomerById(long customerId){
        return customerRepository.findById(customerId);
    }
}
