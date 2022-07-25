package net.york.team3backend.Coupon;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String category;

    Double salePercentage;

    Date start;

    Date end;

    @Nullable
    String code;

    public Coupon(){}

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getSalePercentage() {
        return salePercentage;
    }

    public void setSalePercentage(Double salePercentage) {
        this.salePercentage = salePercentage;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Nullable
    public String getCode() {
        return code;
    }

    public void setCode(@Nullable String code) {
        this.code = code;
    }
}
