package net.york.team3backend.PurchaseEntity;

import net.york.team3backend.Entry.UserEntity;
import net.york.team3backend.ProductsPurchased.ProductsPurchased;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    UserEntity userEntity;

    @OneToMany
    Set<ProductsPurchased> purchased = new HashSet<>();

    Date datePurchased;

    public PurchaseEntity(){}

    public Long getId() {
        return id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }

    public Set<ProductsPurchased> getPurchased() {
        return purchased;
    }

    public void setPurchased(Set<ProductsPurchased> purchased) {
        this.purchased = purchased;
    }
}
