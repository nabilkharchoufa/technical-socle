package com.total.demands.app.rest.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemandsUpdateJSONRequest {

    public final String title;

    public final String description;

    public final Long dueDateTimeStamp;

    public DemandsUpdateJSONRequest(@JsonProperty("title")String title,
                                    @JsonProperty("description")String description,
                                    @JsonProperty("dueDate")Long dueDate) {
        this.title = title;
        this.description=description;
        this.dueDateTimeStamp = dueDate;
    }
}
