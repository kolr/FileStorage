package com.cloud.validation.annotation;

import com.cloud.validation.annotation.validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 11.07.2016
 * Created by Rodion.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
    String message() default "{Email}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
