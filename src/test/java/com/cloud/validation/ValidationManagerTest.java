package com.cloud.validation;

import com.cloud.entities.beans.RegistrationBean;
import com.cloud.entities.beans.SignInBean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 12.07.2016
 * Created by Rodion.
 */
public class ValidationManagerTest {
    private static final String VERIFY_TRACKER_EMAIL = "example@example.com";
    private static final String VERIFY_TRACKER_EMAIL_INCORRECT = "exampl";
    private static final String VERIFY_TRACKER_PASSWORD = "password2";
    private static final String VERIFY_TRACKER_PASSWORD_INCORRECT = "pas";
    private static final String VERIFY_TRACKER_NAME = "John";
    private static final String VERIFY_TRACKER_NAME_INCORRECT = "John2";
    private static final String VERIFY_TRACKER_LASTNAME = "Doe";

    private static ValidationManager validationManager;

    @BeforeClass
    public static void setUp() {
        validationManager = new ValidationManager();
    }

    @Test
    public void validateCorrectTest() {
        SignInBean test = new SignInBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_PASSWORD);
        boolean actual = validationManager.validate(test, SignInBean.class);

        assertTrue(actual);
    }

    @Test
    public void validateIncorrectEmailTest() {
        SignInBean test = new SignInBean(VERIFY_TRACKER_EMAIL_INCORRECT, VERIFY_TRACKER_PASSWORD);
        boolean actual = validationManager.validate(test, SignInBean.class);

        assertFalse(actual);
    }

    @Test
    public void validateIncorrectPasswordTest() {
        SignInBean test = new SignInBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_PASSWORD_INCORRECT);
        boolean actual = validationManager.validate(test, SignInBean.class);

        assertFalse(actual);
    }

    @Test
    public void validateIncorrectBothTest() {
        SignInBean test = new SignInBean(VERIFY_TRACKER_EMAIL_INCORRECT, VERIFY_TRACKER_PASSWORD_INCORRECT);
        boolean actual = validationManager.validate(test, SignInBean.class);

        assertFalse(actual);
    }

    @Test
    public void validateRegistrationCorrectDataTest() {
        RegistrationBean test = new RegistrationBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_NAME,
                VERIFY_TRACKER_LASTNAME, VERIFY_TRACKER_PASSWORD);
        boolean actual = validationManager.validate(test, RegistrationBean.class);

        assertTrue(actual);
    }

    @Test
    public void validateRegistrationIncorrectDataTest() {
        RegistrationBean test = new RegistrationBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_NAME,
                VERIFY_TRACKER_LASTNAME, VERIFY_TRACKER_PASSWORD_INCORRECT);
        boolean actual = validationManager.validate(test, RegistrationBean.class);

        assertFalse(actual);
    }

    @Test
    public void validateRegistrationIncorrectNameTest() {
        RegistrationBean test = new RegistrationBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_NAME_INCORRECT,
                VERIFY_TRACKER_LASTNAME, VERIFY_TRACKER_PASSWORD);
        boolean actual = validationManager.validate(test, RegistrationBean.class);

        assertFalse(actual);
    }

    @Test
    public void validateRegistrationIncorrectEmailTest() {
        RegistrationBean test = new RegistrationBean(VERIFY_TRACKER_EMAIL_INCORRECT, VERIFY_TRACKER_NAME,
                VERIFY_TRACKER_LASTNAME, VERIFY_TRACKER_PASSWORD);
        boolean actual = validationManager.validate(test, RegistrationBean.class);

        assertFalse(actual);
    }

}
