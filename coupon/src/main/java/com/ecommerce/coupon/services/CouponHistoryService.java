package com.ecommerce.coupon.services;

import com.ecommerce.coupon.entities.coupon.Coupon;
import com.ecommerce.coupon.entities.coupon.CouponDTO;
import com.ecommerce.coupon.entities.coupon.CouponMapper;
import com.ecommerce.coupon.entities.couponHistory.CouponHistory;
import com.ecommerce.coupon.entities.couponHistory.CouponHistoryDTO;
import com.ecommerce.coupon.entities.couponHistory.CouponHistoryMapper;
import com.ecommerce.coupon.exceptions.NotFoundException;
import com.ecommerce.coupon.repositories.CouponHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CouponHistoryService {
    @Autowired
    private CouponHistoryRepository couponHistoryRepository;

    public List<CouponHistoryDTO> getCouponsHistory() {
        List<CouponHistory> couponsHistory = couponHistoryRepository.findAll();
        List<CouponHistoryDTO> couponsHistoryDTO = new ArrayList<>();

        for (CouponHistory couponHistory : couponsHistory) {
            couponsHistoryDTO.add(CouponHistoryMapper.INSTANCE.toDto(couponHistory));
        }
        return couponsHistoryDTO;
    }

    public List<CouponHistoryDTO> getOneCouponHistory(long code){
        List<CouponHistory> couponHistory = couponHistoryRepository.findByCouponCode(code);
        if (couponHistory.isEmpty()) {
            throw new NotFoundException("No History for this coupon " + code);
        }

        List<CouponHistoryDTO> couponHistoryDTO = new ArrayList<>();
        for (CouponHistory oneCouponHistory:couponHistory) {
            couponHistoryDTO.add(CouponHistoryMapper.INSTANCE.toDto(oneCouponHistory));
        }
        return couponHistoryDTO;
    }
}
