package com.example.example.utilis.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Excepcion personalizada de 401*/

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized402 extends Exception{

    public ApiUnauthorized402(String message){
        super(message);
    }
}
