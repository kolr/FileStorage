package com.cloud.exceptions.user;

/**
 * 22.08.2016
 * Created by Rodion.
 */
public class UserNotLoggedInException extends Exception {
    public UserNotLoggedInException() {
        super();
    }

    public UserNotLoggedInException(String message, Throwable exception) {
        super(message, exception);
    }

    public UserNotLoggedInException(String message) {
        super(message);
    }
}
