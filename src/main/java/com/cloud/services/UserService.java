package com.cloud.services;


import com.cloud.entities.User;
import com.cloud.storage.Storage;

import javax.inject.Inject;
import java.util.Collection;

/**
 * ${APP}
 * Created by Rodion on 11.03.2016.
 */


public class UserService {

    @Inject
    Storage storage;

    public void addUser(User user) {
        storage.addUser(user);
    }

    public User getUser(String login) {
        return storage.getUser(login);
    }

    public Collection<User> getALl() {
        return storage.getAllUsers();
    }

    @Override
    public String toString() {
        return "UserService{}";
    }
}