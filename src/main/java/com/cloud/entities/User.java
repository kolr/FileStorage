package com.cloud.entities;

//import org.hibernate.annotations.OptimisticLockType;
//import org.hibernate.annotations.Table;
//import org.hibernate.boot.model.relational.Namespace;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.io.Serializable;

/**
 * ${APP}
 * Created by Rodion on 11.03.2016.
 */

@Entity
//@Table(name = "user")
public class User{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String folder;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String login) {
        this.email = login;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
       this.id = id;
    }

    public String getFolder() {

        return folder;
    }
    public void setFolder(String folder){
        this.folder = folder;
    }

}
