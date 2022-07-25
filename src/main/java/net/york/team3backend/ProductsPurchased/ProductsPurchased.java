package net.york.team3backend.ProductsPurchased;

import net.york.team3backend.ProductsSold.ProductsSold;
import net.york.team3backend.PurchaseEntity.PurchaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class ProductsPurchased {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_entity_id")
    PurchaseEntity purchaseEntity;

    @OneToMany
    Set<ProductsSold> sold = new HashSet<>();

    String purchasesString;



    public ProductsPurchased(){}
}
