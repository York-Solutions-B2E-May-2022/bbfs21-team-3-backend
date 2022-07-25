package net.york.team3backend.Coupon;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String category;

    private Double salePercentage;

    private Date startDate;

    private Date endDate;

    @Nullable
    private String code;

    public CouponEntity(){}

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
        return startDate;
    }

    public void setStart(Date start) {
        this.startDate = start;
    }

    public Date getEnd() {
        return endDate;
    }

    public void setEnd(Date end) {
        this.endDate = end;
    }

    @Nullable
    public String getCode() {
        return code;
    }

    public void setCode(@Nullable String code) {
        this.code = code;
    }
}
