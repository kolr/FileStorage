package com.cloud.validation.annotation.validator;

import com.cloud.validation.FieldTypes;
import com.cloud.validation.annotation.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 11.07.2016
 * Created by Rodion.
 */
public class EmailValidator implements ConstraintValidator<Email, String> {

    public void initialize(Email email) {

    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        return s.matches(FieldTypes.EMAIL.getRegExp());
    }
}
