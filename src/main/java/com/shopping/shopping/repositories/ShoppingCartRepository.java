package com.shopping.shopping.repositories;

import com.shopping.shopping.entities.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
