package com.cloud.validation;

/**
 * 11.07.2016
 * Created by Rodion.
 */
public class VerifiableField {
    private static final FieldTypes DEFAULT_TYPE = FieldTypes.NAME;
    private static final String DEFAULT_REGEXP = "";
    private static final boolean DEFAULT_REQUIRED = true;
    private static final boolean DEFAULT_VALID = false;

    private FieldTypes type;
    private String value;
    private String regexp;
    private boolean required;
    private boolean valid;

    public VerifiableField() {
        this.type = DEFAULT_TYPE;
        this.regexp = DEFAULT_REGEXP;
        this.required = DEFAULT_REQUIRED;
        this.valid = DEFAULT_VALID;
    }

    public VerifiableField(FieldTypes type, String value) {
        this.type = type;
        this.value = value;
        this.regexp = type.getRegExp();
        this.required = DEFAULT_REQUIRED;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
