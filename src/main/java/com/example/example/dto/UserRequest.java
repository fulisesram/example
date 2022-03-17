package com.example.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class UserRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

}
