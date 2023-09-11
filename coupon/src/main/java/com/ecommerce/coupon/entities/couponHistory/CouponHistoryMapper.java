package com.ecommerce.coupon.entities.couponHistory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface CouponHistoryMapper {
    CouponHistoryMapper INSTANCE = Mappers.getMapper(CouponHistoryMapper.class);
    @Mapping(source = "coupon.couponCode",target = "couponCode")
    CouponHistoryDTO toDto(CouponHistory couponHistory);
}
