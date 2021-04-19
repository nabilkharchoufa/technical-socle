package com.total.demands.demands.infra.repository;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("REQUEST_RESOURCE")
@Data
@NoArgsConstructor
public class DemandsEntity {

    @Id
    @Column("REQUEST_RESOURCE_ID")
    private Long id;

    @Column("TITLE")
    private String title;

    @Column("DESCRIPTION")
    private String description;

    @Column("CREATION_DATE")
    private LocalDateTime creationDateTime;

    @Column("DUE_DATE")
    private LocalDateTime dueDateTime;
}
