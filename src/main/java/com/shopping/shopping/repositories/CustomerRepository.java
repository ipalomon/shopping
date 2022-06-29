package com.shopping.shopping.repositories;

import com.shopping.shopping.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
