package com.ecommerce.coupon.exceptions;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiBaseException {
    public NotFoundException(String message){
        super(message);
    }
    public HttpStatus getStatusCode(){
        return HttpStatus.NOT_FOUND;
    }
}
