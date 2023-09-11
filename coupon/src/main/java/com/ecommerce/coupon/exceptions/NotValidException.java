package com.ecommerce.coupon.exceptions;

import org.springframework.http.HttpStatus;

public class NotValidException extends ApiBaseException {
    public NotValidException(String message){
        super(message);
    }
    public HttpStatus getStatusCode(){
        return HttpStatus.SERVICE_UNAVAILABLE;
    }
}
