package com.shopping.shopping;

import com.shopping.shopping.entities.Product;
import com.shopping.shopping.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GetSetDataFromToBdTest {

    @Autowired
    ProductService productService;

    @Test
    void getProductFrommBdById(){
        Optional<Product> product = productService.findProductById(3L);
        boolean isPresent = product.isPresent();
        assertTrue(isPresent);
    }
}
