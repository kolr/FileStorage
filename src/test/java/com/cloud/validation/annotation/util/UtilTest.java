package com.cloud.validation.annotation.util;

import com.cloud.entities.beans.RegistrationBean;
import com.cloud.entities.beans.SignInBean;
import com.cloud.validation.VerifiableField;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

/**
 * 12.07.2016
 * Created by Rodion.
 */
public class UtilTest {
    private static final String VERIFY_TRACKER_EMAIL = "example@example.com";
    private static final String VERIFY_TRACKER_PASSWORD = "pass";
    private static final String VERIFY_TRACKER_NAME = "John";
    private static final String VERIFY_TRACKER_LASTNAME = "Doe";

    @Test
    public void testVerifyTrackerEmail() {
        SignInBean obj = new SignInBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_PASSWORD);
        List<VerifiableField> fields = null;
        try {
            fields = VerifyTracker.trackVerifyFields(obj, SignInBean.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(VERIFY_TRACKER_EMAIL, fields.get(0).getValue());
    }

    @Test
    public void testVerifyTrackerPassword() {
        SignInBean obj = new SignInBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_PASSWORD);
        List<VerifiableField> fields = null;
        try {
            fields = VerifyTracker.trackVerifyFields(obj, SignInBean.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(VERIFY_TRACKER_PASSWORD, fields.get(1).getValue());
    }

    @Test
    public void testVerifyTrackerArraySize() {
        SignInBean obj = new SignInBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_PASSWORD);
        List<VerifiableField> fields = null;
        try {
            fields = VerifyTracker.trackVerifyFields(obj, SignInBean.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(2, fields.size());
    }

    @Test
    public void testVerifyTrackerArraySizeReg() {
        RegistrationBean obj = new RegistrationBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_NAME,
                VERIFY_TRACKER_LASTNAME, VERIFY_TRACKER_PASSWORD);
        List<VerifiableField> fields = null;
        try {
            fields = VerifyTracker.trackVerifyFields(obj, RegistrationBean.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(4, fields.size());
    }

    @Test
    public void testVerifyTrackerArrayNameReg() {
        RegistrationBean obj = new RegistrationBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_NAME,
                VERIFY_TRACKER_LASTNAME, VERIFY_TRACKER_PASSWORD);
        List<VerifiableField> fields = null;
        try {
            fields = VerifyTracker.trackVerifyFields(obj, RegistrationBean.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(VERIFY_TRACKER_NAME, fields.get(1).getValue());
    }

    @Test
    public void testVerifyTrackerArrayLastnameReg() {
        RegistrationBean obj = new RegistrationBean(VERIFY_TRACKER_EMAIL, VERIFY_TRACKER_NAME,
                VERIFY_TRACKER_LASTNAME, VERIFY_TRACKER_PASSWORD);
        List<VerifiableField> fields = null;
        try {
            fields = VerifyTracker.trackVerifyFields(obj, RegistrationBean.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(VERIFY_TRACKER_LASTNAME, fields.get(2).getValue());
    }
}
