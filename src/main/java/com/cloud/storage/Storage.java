package com.cloud.storage;

import com.cloud.entities.User;

import java.util.*;

/**
 * ${APP}
 * Created by Rodion on 11.03.2016.
 */
public class Storage {
    Map<String, User> users;

    public Storage() {
        users = new HashMap<String, User>();
    }

    public void addUser(User user) {
        this.users.put(user.getEmail(), user);
    }

    public User getUser(String login) {
        return this.users.get(login);
    }

    public Collection<User> getAllUsers() {
        return this.users.values();
    }
}
