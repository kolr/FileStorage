package com.cloud.entities.beans;

/**
 * 11.07.2016
 * Created by Rodion.
 */
public class SignUpBean {
    private String email;
    private String password;

    public SignUpBean() {
    }

    public SignUpBean(String email, String password) {
        this.email = email;
        this.password = password;
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
