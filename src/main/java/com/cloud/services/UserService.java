package com.cloud.services;


import com.cloud.entities.User;
import com.cloud.entities.beans.SignInBean;
import com.cloud.storage.Storage;
import com.cloud.validation.ValidationManager;

import javax.inject.Inject;
import java.util.Collection;

/**
 * ${APP}
 * Created by Rodion on 11.03.2016.
 */


public class UserService {

    @Inject
    Storage storage;

    @Inject
    ValidationManager validationManager;

    public void addUser(User user) {
        storage.addUser(user);
    }

    //TODO implement DAO layer.
    public User getUser(SignInBean credentials) {
        boolean valid = validationManager.validate(credentials, SignInBean.class);
        if (valid) {
            // Waiting for DAO implementation.
        }
        return null;
    }

    public Collection<User> getALl() {
        return storage.getAllUsers();
    }

    @Override
    public String toString() {
        return "UserService{}";
    }
}
