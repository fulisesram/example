package com.example.example.utilis.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Excepcion personalizada de 404*/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound404 extends Exception{

    public ApiNotFound404(String message){
        super (message);
    }

}
