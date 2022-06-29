package com.shopping.shopping.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="product")
@Table(name="PRODUCT_TABLE")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private long productId;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="PRODUCT_DESCRIPTION")
    private String productDescription;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ITEM_FK")
    private ItemToPurchase itemToPurchase;

    public Product(String productName, String productDescription) {
        this.productName = productName;
        this.productDescription = productDescription;
    }
}
