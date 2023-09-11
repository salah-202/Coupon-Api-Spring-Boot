package com.ecommerce.coupon.controllers;

import com.ecommerce.coupon.entities.couponHistory.CouponHistoryDTO;
import com.ecommerce.coupon.services.CouponHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Coupon history Api")
@RequestMapping("/e-commerce")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    @Operation(summary = "List History of all used coupons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CouponsHistory returned",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CouponHistoryDTO.class)) })
    })
    @GetMapping("/couponsHistory")
    public ResponseEntity<List<CouponHistoryDTO>> getCouponsHistory(){
        List<CouponHistoryDTO> couponsHistory = couponHistoryService.getCouponsHistory();
        return new ResponseEntity<>(couponsHistory, HttpStatus.OK);
    }

    @Operation(summary = "List History of one used coupon by it's code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "One Coupon History returned", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CouponHistoryDTO.class))}),
            @ApiResponse(responseCode = "404", description = "No CouponHistory found", content = @Content)
    })
    @GetMapping("/couponsHistory/{code}")
    public ResponseEntity<List<CouponHistoryDTO>> getOneCouponHistory(@PathVariable long code){
        List<CouponHistoryDTO> oneCouponHistory = couponHistoryService.getOneCouponHistory(code);
        return new ResponseEntity<>(oneCouponHistory, HttpStatus.OK);
    }
}
