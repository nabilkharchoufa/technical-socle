package com.total.demands.presentation;

import com.total.demands.domain.validators.DescriptionValidator;
import com.total.demands.domain.validators.DueDateValidator;
import com.total.demands.domain.validators.TitleValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemandsCreationRequest {
    
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String DUE_DATE = "dueDate";

    public final String title;

    public final String description;

    public final Long dueDateTimeStamp;

    private DemandsCreationRequest(String title, String description, Long dueDateTimeStamp) {
        this.title = title;
        this.description = description;
        this.dueDateTimeStamp = dueDateTimeStamp;
    }

    public static DemandsCreationRequest createDemandsRequest(String title, String description, Long dueDatetimetimeStamp) throws DemandsDomainException {
        validate(title, description, dueDatetimetimeStamp);
        return new DemandsCreationRequest(title, description, dueDatetimetimeStamp);
    }

    private static void validate(String title, String description, Long dueDateTimeStamp) throws DemandsDomainException {
        List<DemandsError> errors = new ArrayList<>();

        errors.addAll(TitleValidator.validate(title).
                stream().map(vr -> new DemandsError(vr.code, TITLE, vr.message)).collect(Collectors.toList()));
        errors.addAll(DescriptionValidator.validate(description).
                stream().map(vr -> new DemandsError(vr.code, DESCRIPTION, vr.message)).collect(Collectors.toList()));
        errors.addAll(DueDateValidator.validate(dueDateTimeStamp).
                stream().map(vr -> new DemandsError(vr.code, DUE_DATE, vr.message)).collect(Collectors.toList()));

        if (!errors.isEmpty()) {
            throw new DemandsDomainException(errors);
        }
    }
}
