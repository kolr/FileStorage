package com.cloud.validation;

import com.cloud.validation.annotation.util.VerifyTracker;
import com.cloud.validation.entities.Verifiable;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 12.07.2016
 * Created by Rodion.
 */
public class ValidationManager {
    private static final Logger LOG = Logger.getLogger(ValidationManager.class);

    public boolean validate(Verifiable obj, Class<?> cl) {
        List<VerifiableField> fields;
        try {
            fields = VerifyTracker.trackVerifyFields(obj, cl);
        } catch (IllegalAccessException e) {
            LOG.error(e);
            return false;
        }
        return fields != null && validateFields(fields);
    }

    private boolean validateFields(List<VerifiableField> fields) {
        boolean result = true;
        for (VerifiableField field : fields) {
            Pattern pattern = Pattern.compile(field.getRegexp());
            Matcher matcher = pattern.matcher(field.getValue());
            boolean matchingResult = matcher.matches();
            if (!matchingResult) {
                result = false;
                break;
            }
        }
        return result;
    }
}
