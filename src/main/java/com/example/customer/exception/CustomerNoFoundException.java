package com.example.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNoFoundException extends RuntimeException {
    public CustomerNoFoundException(String msg){
        super(msg);
    }
}
