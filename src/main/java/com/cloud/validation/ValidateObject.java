package com.cloud.validation;

/**
 * 11.07.2016
 * Created by Rodion.
 * <p>
 * Class of the object, that system going to validate, must inherit this abstract class.
 */
public abstract class ValidateObject {
    protected FieldTypes type;

    abstract void setFieldType(FieldTypes type);
}
