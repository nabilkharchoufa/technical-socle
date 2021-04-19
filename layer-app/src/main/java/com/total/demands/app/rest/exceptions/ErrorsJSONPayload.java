package com.total.demands.app.rest.exceptions;

import com.total.demands.presentation.DemandsError;

import java.util.ArrayList;
import java.util.List;

public class ErrorsJSONPayload {
    
    public final List<ErrorJSON> errors;

    public ErrorsJSONPayload(List<DemandsError> applicationErrors) {
        this.errors = new ArrayList<>();
        applicationErrors.forEach(applicationError -> errors.add(fromApplicationError(applicationError)));
    }

    private ErrorJSON fromApplicationError(DemandsError applicationError) {
        return new ErrorJSON(applicationError.code, applicationError.field, applicationError.description);
    }
}
