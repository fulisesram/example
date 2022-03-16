package com.example.example.utilis.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Excepcion personalizada de estatus 422 */

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity422 extends Exception{

    public ApiUnprocessableEntity422(String message){
        super(message);
    }

}
