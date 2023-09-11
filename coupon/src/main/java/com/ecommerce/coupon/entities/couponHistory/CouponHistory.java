package com.ecommerce.coupon.entities.couponHistory;

import com.ecommerce.coupon.entities.coupon.Coupon;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "coupon_history")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CouponHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "coupon_code")
    private Coupon coupon;
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "usage_date")
    private final Date usageDate = new Date();
}
