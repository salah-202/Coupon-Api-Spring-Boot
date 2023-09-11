package com.ecommerce.coupon.entities.coupon;

import com.ecommerce.coupon.entities.couponHistory.CouponHistory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coupon_code")
    private Long couponCode;
    @Column(name = "created_date")
    private final Date createdDate = new Date();
    @Column(name = "expiry_date")
    private Date expiryDate;
    @Column(name = "max_usages")
    private int maxUsages;
    @Column(name = "current_usages")
    private int currentUsages;
    @Column(name = "is_valid")
    private Boolean isValid;
    @Column(name = "is_percentage")
    private Boolean isPercentage;
    @Column(name = "coupon_value")
    private float couponValue;
    @OneToMany(mappedBy = "coupon",cascade=CascadeType.ALL)
    private List<CouponHistory> couponHistoryList;

    public void addCouponHistory(CouponHistory couponHistory){
        if(couponHistoryList == null){
            couponHistoryList = new ArrayList<>();
        }
        couponHistoryList.add(couponHistory);
        couponHistory.setCoupon(this);
    }
}
