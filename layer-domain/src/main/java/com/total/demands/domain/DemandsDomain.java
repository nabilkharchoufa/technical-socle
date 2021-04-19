package com.total.demands.domain;

import com.total.demands.presentation.DemandsUpdateRequest;
import com.total.demands.presentation.ReadDemandsResponse;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class DemandsDomain {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDatTime;

    private LocalDateTime dueDateTime;

    public DemandsDomain(String title, String description, Long dueDateTimeStamp) {
        this.title = title;
        this.description = description;
        this.creationDatTime = LocalDateTime.now();
        this.dueDateTime = timeStampToLocalDate(dueDateTimeStamp);
    }

    public DemandsDomain(Long id, String title, String description, LocalDateTime creationDatTime, LocalDateTime dueDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDatTime = creationDatTime;
        this.dueDateTime = dueDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDatTime() {
        return creationDatTime;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public ReadDemandsResponse buildDemandsResponse() {
        return new ReadDemandsResponse(id, title, description, creationDatTime, dueDateTime);
    }

    public DemandsDomain updateFromUpdateRequest(DemandsUpdateRequest request) {
        this.title=request.title;
        this.description= request.description;
        this.dueDateTime = timeStampToLocalDate(request.dueDateTimeStamp);
        return this;
    }

    private LocalDateTime timeStampToLocalDate(Long dueDateTimeStamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(dueDateTimeStamp), TimeZone
                .getDefault().toZoneId());
    }
}
