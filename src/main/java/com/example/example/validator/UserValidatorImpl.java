package com.example.example.validator;

import com.example.example.dto.UserRequest;
import com.example.example.utilis.Exceptions.ApiUnprocessableEntity422;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements IUserValidator{

    @Override
    public void validator(UserRequest request) throws ApiUnprocessableEntity422 {

        if(request.getFirstname() == null || request.getFirstname().isEmpty()){
            message("El nombre es obligatorio");
        }
        if (request.getFirstname().length() < 3){
            message("El nombre es muy corto, debe tener minimo  3 caracteres");
        }
        /* Hacer lo mismo con los demas campos que faltan */

    }

    private void message(String message) throws ApiUnprocessableEntity422 {
        throw new ApiUnprocessableEntity422(message);
    }

}
