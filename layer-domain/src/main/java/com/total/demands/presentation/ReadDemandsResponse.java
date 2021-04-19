package com.total.demands.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReadDemandsResponse {

    private final Long id;

    private final String title;

    private final String description;

    private final LocalDateTime creationDatTime;

    private final LocalDateTime dueDateTime;
}
