package com.cloud.validation;

/**
 * 11.07.2016
 * Created by Rodion.
 */
public class Field {
    private static final FieldTypes DEFAULT_TYPE = FieldTypes.NAME;
    private static final String DEFAULT_REGEXP = "";
    private static final boolean DEFAULT_REQUIRED = true;
    private static final boolean DEFAULT_VALID = false;

    private FieldTypes type;
    private String regexp;
    private boolean required;
    private boolean valid;

    public Field() {
        this.type = DEFAULT_TYPE;
        this.regexp = DEFAULT_REGEXP;
        this.required = DEFAULT_REQUIRED;
        this.valid = DEFAULT_VALID;
    }

    public Field(FieldTypes type) {
        this.type = type;
        this.regexp = type.getRegExp();
        this.required = DEFAULT_REQUIRED;
        this.valid = DEFAULT_VALID;
    }

    public Field(FieldTypes type, boolean required) {
        this.type = type;
        this.regexp = type.getRegExp();
        this.required = required;
        this.valid = DEFAULT_VALID;
    }

    public FieldTypes getType() {
        return type;
    }

    public void setType(FieldTypes type) {
        this.type = type;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
