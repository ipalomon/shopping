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
@Entity(name="ItemToPurchase")
@Table(name="ITEM_TABLE")
public class ItemToPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ITEM_TO_PURCHASE_ID")
    private long itemToPurchaseId;
    @Column(name="QUANTITY")
    private double quantity;
    @Column(name="PRICE_PER_UNIT")
    private double pricePerUnit;

    @OneToOne(mappedBy = "itemToPurchase", cascade = CascadeType.ALL)
    private Product product;

    @ManyToMany(mappedBy = "itemToPurchases", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();

    public ItemToPurchase(double quantity, double pricePerUnit) {
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
}
