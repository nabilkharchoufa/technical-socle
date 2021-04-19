package com.total.demands.domain.validators;

public enum ValidationError {

    EMPTY_FIELD("EMPTY_FIELD", "Veuillez saisir ce champ"),
    INVALID_NUMBER("INVALID_NUMBER", "format du nombre invalide"),
    INVALID_REQUEST_RESOURCE_NUMBER("INVALID_REQUEST_RESOURCE_NUMBER", "aucun REQUEST_RESOURCE avec cet id");

    public final String code;
    public final String message;

    ValidationError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
