package com.cloud.entities.beans;

import com.cloud.validation.FieldTypes;
import com.cloud.validation.annotation.Verify;
import com.cloud.validation.entities.Verifiable;

/**
 * 12.07.2016
 * Created by Rodion.
 */
public class RegistrationBean implements Verifiable {
    
    @Verify(type = FieldTypes.EMAIL)
    private String email;

    @Verify(type = FieldTypes.NAME)
    private String name;

    @Verify(type = FieldTypes.NAME)
    private String lastname;

    @Verify(type = FieldTypes.PASSWORD)
    private String password;

    private String folder;

    public RegistrationBean(String email, String name, String lastname, String password) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
