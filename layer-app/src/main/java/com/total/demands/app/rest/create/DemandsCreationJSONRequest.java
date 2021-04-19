package com.total.demands.app.rest.create;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemandsCreationJSONRequest {

    public final String title;

    public final String description;

    public final Long dueDateTimeStamp;

    public DemandsCreationJSONRequest(@JsonProperty("title")String title,
                                      @JsonProperty("description")String description,
                                      @JsonProperty("dueDate")Long dueDate) {
        this.title = title;
        this.description=description;
        this.dueDateTimeStamp = dueDate;
    }
}
