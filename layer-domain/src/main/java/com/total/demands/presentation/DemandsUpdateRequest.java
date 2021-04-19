package com.total.demands.presentation;

import com.total.demands.domain.validators.DemandsIdValidator;
import com.total.demands.domain.validators.DescriptionValidator;
import com.total.demands.domain.validators.DueDateValidator;
import com.total.demands.domain.validators.TitleValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemandsUpdateRequest {
    
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String DUE_DATE = "dueDate";
    public static final String ID = "id";

    public final Long id;

    public final String title;

    public final String description;

    public final Long dueDateTimeStamp;

    public DemandsUpdateRequest(Long id, String title, String description, Long dueDateTimeStamp) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDateTimeStamp = dueDateTimeStamp;
    }

    public static DemandsUpdateRequest factory(Long id, String title, String description, Long dueDateTimeStamp) throws DemandsDomainException {
        validate(id, title, description, dueDateTimeStamp);
        return new DemandsUpdateRequest(id, title, description, dueDateTimeStamp);
    }

    private static void validate(Long id, String title, String description, Long dueDateTimeStamp) throws DemandsDomainException {
        List<DemandsError> errors = new ArrayList<>();

        errors.addAll(DemandsIdValidator.validate(id).
                stream().map(vr -> new DemandsError(vr.code, ID, vr.message)).collect(Collectors.toList()));
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
