package com.total.demands.domain.validators;

import java.util.Collections;
import java.util.List;

public class DemandsIdValidator {
    public static List<ValidationError> validate(Long id) {
        if (id == null) {
            return Collections.singletonList(ValidationError.EMPTY_FIELD);
        } if (id < 0) {
            return Collections.singletonList(ValidationError.INVALID_NUMBER);
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
