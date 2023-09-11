package com.ecommerce.coupon.controllers;

import com.ecommerce.coupon.entities.coupon.Coupon;
import com.ecommerce.coupon.entities.coupon.CouponDTO;
import com.ecommerce.coupon.services.CouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Coupon Api")
@RequestMapping("/e-commerce")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Operation(summary = "Get List of coupons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coupons returned",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CouponDTO.class)) })
    })
    @GetMapping("/coupons")
    public ResponseEntity<List<CouponDTO>> getCoupons(){
        List<CouponDTO> coupons = couponService.getCoupons();
        return new ResponseEntity<>(coupons, HttpStatus.OK);
    }


    @Operation(summary = "Add coupon to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coupon created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Coupon.class)) }),
            @ApiResponse(responseCode = "500", description = "An error occurred.", content = @Content) })
    @PostMapping("/coupons")
    public ResponseEntity<CouponDTO> addCoupon(@RequestBody Coupon coupon){
        CouponDTO addedCoupon = couponService.addCoupon(coupon);
        return new ResponseEntity<>(addedCoupon, HttpStatus.CREATED);
    }
    @Operation(summary = "use Coupon by order api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coupon used successfully",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CouponDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "No Coupon found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Invalid Coupon", content = @Content)
    })
    @GetMapping("/coupons/{code}/{orderId}")
    public ResponseEntity<CouponDTO> useCoupon(@PathVariable long code, @PathVariable long orderId){
        CouponDTO usedCoupon = couponService.useCoupon(code,orderId);
        return new ResponseEntity<>(usedCoupon, HttpStatus.OK);
    }
}
