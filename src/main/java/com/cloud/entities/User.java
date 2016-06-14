package com.cloud.entities;

/**
 * ${APP}
 * Created by Rodion on 11.03.2016.
 */
public class User {
    int id;
    String name;
    String lastName;
    String login;
    String pass;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
