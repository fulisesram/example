package com.example.example.dto;

import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String firstname,
            lastname,
            username,
            password;
    private Date created,
            col_update;

}
