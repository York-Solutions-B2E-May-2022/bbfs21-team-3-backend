package net.york.team3backend.Entry;

import net.york.team3backend.PurchaseEntity.PurchaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String name;
    private String email;
    private String password;
    private String role;

    private UUID token;

    @OneToMany
    List<PurchaseEntity> Purchases = new ArrayList<>();

    @Autowired
    public UserEntity(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<PurchaseEntity> getPurchases() {
        return Purchases;
    }

    public void setPurchases(List<PurchaseEntity> purchases) {
        Purchases = purchases;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
