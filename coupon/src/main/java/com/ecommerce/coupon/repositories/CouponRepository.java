package com.ecommerce.coupon.repositories;

import com.ecommerce.coupon.entities.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
}
