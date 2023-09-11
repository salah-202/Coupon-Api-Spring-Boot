package com.ecommerce.coupon.entities.couponHistory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CouponHistoryDTO {
    private Long couponCode;
    private long orderId;
    private Date usageDate;
}
