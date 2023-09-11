package com.ecommerce.coupon.services;

import com.ecommerce.coupon.entities.coupon.Coupon;
import com.ecommerce.coupon.entities.coupon.CouponDTO;
import com.ecommerce.coupon.entities.couponHistory.CouponHistory;
import com.ecommerce.coupon.entities.coupon.CouponMapper;
import com.ecommerce.coupon.exceptions.NotFoundException;
import com.ecommerce.coupon.exceptions.NotValidException;
import com.ecommerce.coupon.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;
    public List<CouponDTO> getCoupons(){
        List<Coupon> coupons = couponRepository.findAll();
        List<CouponDTO> couponsDTO = new ArrayList<>();

        for (Coupon coupon:coupons) {
            couponsDTO.add(CouponMapper.INSTANCE.toDto(coupon));
        }
        return couponsDTO;
    }

    public CouponDTO addCoupon(Coupon coupon) {
        return CouponMapper.INSTANCE.toDto(couponRepository.save(coupon));
    }
    public CouponDTO useCoupon(long code,long orderId){
        Coupon coupon = couponRepository.findById(code).orElseThrow(()-> new NotFoundException("No coupon for this code " + code));

        if(coupon.getMaxUsages() == coupon.getCurrentUsages() || coupon.getExpiryDate().getTime() < new Date().getTime()){
            coupon.setIsValid(false);
            couponRepository.save(coupon);
            throw new NotValidException("The Coupon is Invalid " + code);
        }
        coupon.setCurrentUsages(coupon.getCurrentUsages()+1);

        CouponHistory couponHistory = new CouponHistory();
        couponHistory.setOrderId(orderId);

        coupon.addCouponHistory(couponHistory);
        return CouponMapper.INSTANCE.toDto(couponRepository.save(coupon));
    }
}
