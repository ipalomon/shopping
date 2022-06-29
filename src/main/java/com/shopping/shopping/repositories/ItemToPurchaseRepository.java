package com.shopping.shopping.repositories;

import com.shopping.shopping.entities.ItemToPurchase;
import org.springframework.data.repository.CrudRepository;

public interface ItemToPurchaseRepository extends CrudRepository<ItemToPurchase, Long> {
}
