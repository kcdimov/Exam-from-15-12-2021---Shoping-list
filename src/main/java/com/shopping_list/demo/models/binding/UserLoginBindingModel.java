package com.shopping_list.demo.models.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    //    Has a Username (unique)
//    Username length must be between 3 and 20 characters (inclusive 3 and 20).
//    Has a Password
//    Password length must be between 3 and 20 characters (inclusive 3 and 20).
//    Has an Email
//    Must contains '@'.
//    Cannot be null.
    private String username;
    private String password;


    public UserLoginBindingModel() {
    }

    @NotBlank(message = "Please fill username! Username cannot be empty")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Please fill password! Password cannot be empty")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
