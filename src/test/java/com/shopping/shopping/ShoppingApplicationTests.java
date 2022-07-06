package com.shopping.shopping;

import com.shopping.shopping.entities.Customer;
import com.shopping.shopping.entities.ItemToPurchase;
import com.shopping.shopping.entities.Product;
import com.shopping.shopping.entities.ShoppingCart;
import com.shopping.shopping.repositories.CustomerRepository;
import com.shopping.shopping.repositories.ItemToPurchaseRepository;
import com.shopping.shopping.repositories.ProductRepository;
import com.shopping.shopping.repositories.ShoppingCartRepository;
import com.shopping.shopping.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShoppingApplicationTests {


	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ItemToPurchaseRepository itemToPurchaseRepository;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Test
	void createCustomers() {
		Customer customer1 = new Customer("Joe","Manhattan Str. 4356","5th Avenue 2387","joe@gmail.com","1234",0);
		Customer c1 = customerRepository.save(customer1);

		assertEquals(customer1, c1);
	}

	@Test
	void createProducts(){
		Product product1 = new Product("Boligrafos","Pack de 8 boligrafos de escritura azul");
		Product product2 = new Product("Papel","Bobina de papel de 100 mts.");
		Product product3 = new Product("Bolsas","Bolsas de plastico reciclables");

		Product p1 =productRepository.save(product1);
		Product p2 =productRepository.save(product2);
		Product p3 =productRepository.save(product3);

		assertEquals(product1, p1);
		assertEquals(product2, p2);
		assertEquals(product3, p3);
	}

	@Test
	void assignProductToItem(){
		Product product1 = new Product("Bobinas caucho","Bobinas de 3mm x 30 m");
		Product p1 =productRepository.save(product1);

		ItemToPurchase itemToPurchase1 = new ItemToPurchase(2,34.78);
		ItemToPurchase it1 = itemToPurchaseRepository.save(itemToPurchase1);

		itemToPurchase1.setProduct(product1);
		itemToPurchaseRepository.save(itemToPurchase1);
	}

	@Test
	void assignCartToCustomer(){
		Product product1 = new Product("Papel Satinado blanco","1000 hojas");
		Product p1 =productRepository.save(product1);

		ItemToPurchase itemToPurchase1 = new ItemToPurchase(5,25);
		ItemToPurchase it1 = itemToPurchaseRepository.save(itemToPurchase1);

		product1.setItemtopurchase(itemToPurchase1);
		productRepository.save(product1);


		//Assign item purchase to a cart
		ShoppingCart soppingCart1 = new ShoppingCart(100,21, 121);
		ShoppingCart spc1 = shoppingCartRepository.save(soppingCart1);
		soppingCart1.getItemToPurchases().add(itemToPurchase1);
		shoppingCartRepository.save(soppingCart1);

		itemToPurchase1.getShoppingCarts().add(soppingCart1);
		itemToPurchaseRepository.save(itemToPurchase1);

		// Assign cart to customer
		Customer customer1 = new Customer("James","Lincoln Str 6765","Big Avenue 3333","James@gmail.com","1234",8);
		Customer c1 = customerRepository.save(customer1);

		soppingCart1.setCustomerToPurchase(customer1);
		shoppingCartRepository.save(soppingCart1);

	}

}
