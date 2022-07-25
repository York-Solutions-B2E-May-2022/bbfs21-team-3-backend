package net.york.team3backend.ProductsSold;

import javax.persistence.*;

@Entity
public class ProductsSold {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

}
