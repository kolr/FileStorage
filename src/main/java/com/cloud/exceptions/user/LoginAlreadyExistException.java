package com.cloud.exceptions.user;

/**
 * 25.07.2016
 * Created by Rodion.
 */
public class LoginAlreadyExistException extends Exception {
    public LoginAlreadyExistException() {
        super();
    }

    public LoginAlreadyExistException(String message, Throwable exception) {
        super(message, exception);
    }

    public LoginAlreadyExistException(String message) {
        super(message);
    }
}
