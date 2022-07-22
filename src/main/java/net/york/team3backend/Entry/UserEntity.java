package net.york.team3backend.Entry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String name;
    private String email;
    private String password;
    private String role;

    @OneToMany
    List<PurchaseEntity> Purchases = new ArrayList<>();
}
