package com.cloud.entities.beans;

import com.cloud.validation.FieldTypes;
import com.cloud.validation.annotation.Verify;
import com.cloud.validation.entities.Verifiable;

/**
 * 12.07.2016
 * Created by Rodion.
 */
public class SignInBean implements Verifiable {
    @Verify(type = FieldTypes.EMAIL)
    private String email;

    @Verify(type = FieldTypes.PASSWORD)
    private String password;

    public SignInBean(String email, String password) {
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

    @Override
    public String toString() {
        return "SignInBean{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
