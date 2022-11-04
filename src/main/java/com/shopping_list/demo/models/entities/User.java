package com.shopping_list.demo.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

//    Has an Id – UUID-string or Long
//    Has a Username (unique)
//    Username length must be between 3 and 20 characters (inclusive 3 and 20).
//    Has a Password
//    Password length must be between 3 and 20 characters (inclusive 3 and 20).
//    Has an Email
//    Must contains '@'.
//    Cannot be null.

    private String username;
    private String password;
    private String email;

    public User() {
    }

    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
