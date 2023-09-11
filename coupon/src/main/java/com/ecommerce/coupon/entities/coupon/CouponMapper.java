package com.ecommerce.coupon.entities.coupon;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface CouponMapper {
    CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);
    CouponDTO toDto(Coupon coupon);
}
