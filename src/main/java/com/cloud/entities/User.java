package com.cloud.entities;

import com.cloud.validation.annotation.Email;

/**
 * ${APP}
 * Created by Rodion on 11.03.2016.
 */
public class User {
    private int id;
    private String name;
    private String lastName;

    @Email
    private String email;
    private String pass;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(String role) {
        this.id = id;
    }
}
