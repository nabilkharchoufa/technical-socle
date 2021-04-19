package com.total.demands.presentation;

public class DemandsError {

    public final String code;
    public final String field;
    public final String description;

    public DemandsError(String code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
