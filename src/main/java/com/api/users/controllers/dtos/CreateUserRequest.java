package com.api.users.controllers.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateUserRequest {

    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot be blank")
    private String username;
    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.")
    private String email;
    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot be blank")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
