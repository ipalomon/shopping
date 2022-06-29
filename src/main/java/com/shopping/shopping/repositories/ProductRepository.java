package com.shopping.shopping.repositories;

import com.shopping.shopping.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
