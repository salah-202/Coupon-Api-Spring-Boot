package com.ecommerce.coupon.entities.coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CouponDTO {
    private Long couponCode;
    private Boolean isValid;
    private Boolean isPercentage;
    private float couponValue;
}
