package com.example.example.validator;

import com.example.example.dto.UserRequest;
import com.example.example.utilis.Exceptions.ApiUnprocessableEntity422;
import org.springframework.stereotype.Service;

/** Interface para la validacion de datos recibidos parala creacion de usuarios */

@Service
public interface IUserValidator {

    void validator(UserRequest request) throws ApiUnprocessableEntity422;

}
