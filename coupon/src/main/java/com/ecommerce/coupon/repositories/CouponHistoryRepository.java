package com.ecommerce.coupon.repositories;

import com.ecommerce.coupon.entities.couponHistory.CouponHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponHistoryRepository extends JpaRepository<CouponHistory,Long> {
    @Query(value = "SELECT * FROM coupon_history WHERE coupon_code = :code", nativeQuery = true)
    List<CouponHistory> findByCouponCode(@Param("code") long code);
}
