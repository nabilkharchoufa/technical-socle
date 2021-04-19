package com.total.demands.app.rest.read;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Class for Demand detail json response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandsDetailJSONResponse {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDatTime;

    private LocalDateTime dueDateTime;
}
