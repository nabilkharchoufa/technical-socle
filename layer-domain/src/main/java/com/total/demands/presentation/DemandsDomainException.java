package com.total.demands.presentation;

import java.util.List;

public class DemandsDomainException extends Exception {

    public final List<DemandsError> errors;

    public DemandsDomainException(List<DemandsError> errors) {
        this.errors=errors;
    }
}
