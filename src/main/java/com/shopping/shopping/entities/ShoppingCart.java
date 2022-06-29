package com.shopping.shopping.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="ShoppingCart")
@Table(name="CART_TABLE")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SOPPING_CART_ID")
    private long soppingCartId;
    @Column(name="SUBTOTAL_MONEY")
    private double subtotalMoney;
    @Column(name="VAT_AMOUNT")
    private double vatAmount;
    @Column(name="TOTAL_MONEY")
    private double totalMoney;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_FK")
    private Customer customerToPurchase;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(	name = "CART_ITEM_JOIN_TABLE",
            joinColumns = { @JoinColumn(name = "SOPPING_CART_FK") },
            inverseJoinColumns = { @JoinColumn(name = "ITEM_TO_PURCHASE_FK") })
    private List<ItemToPurchase> itemToPurchases = new ArrayList<>();


    public ShoppingCart(double subtotalMoney, double vatAmount, double totalMoney) {
        this.subtotalMoney = subtotalMoney;
        this.vatAmount = vatAmount;
        this.totalMoney = totalMoney;
    }
}
