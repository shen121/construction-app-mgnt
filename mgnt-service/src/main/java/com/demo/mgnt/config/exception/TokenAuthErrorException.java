package com.demo.mgnt.config.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.UNAUTHORIZED )
public class TokenAuthErrorException extends RuntimeException{

    public TokenAuthErrorException(){

    }
    public TokenAuthErrorException(String message){
        super(message);
    }
}
