package com.shopping.shopping.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="customer")
@Table(name="CUSTOMER_TABLE")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CUSTOMER_ID")
    private long customerId;
    @Column(name="CUSTOMER_NAME")
    private String customerName;
    @Column(name="BILLING_ADDRESS")
    private String billingAddress;
    @Column(name="SHIPPING_ADDRESS")
    private String shippingAddress;
    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;
    @Column(name="password")
    private String password;
    @Column(name="DISCOUNT_RATE")
    private int discountRate;

    @OneToOne(mappedBy = "customerToPurchase", cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    public Customer(String customerName, String billingAddress, String shippingAddress, String emailAddress, String password, int discountRate) {
        this.customerName = customerName;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.emailAddress = emailAddress;
        this.password = password;
        this.discountRate = discountRate;
    }
}
