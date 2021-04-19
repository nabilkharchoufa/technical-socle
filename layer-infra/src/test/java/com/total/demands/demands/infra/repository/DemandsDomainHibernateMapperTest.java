package com.total.demands.demands.infra.repository;

import com.total.demands.domain.DemandsDomain;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class DemandsDomainHibernateMapperTest {


    public static final long ID = 12L;
    public static final String TITLE = "Test de titre";
    public static final String DESCRIPTION = "Il était une fois un homme triste, faisant des TUs";
    private static final LocalDateTime CREATION_DATE = LocalDateTime.of(2021, Month.NOVEMBER,
            6,00,00,00);
    private static final LocalDateTime DUE_DATE = LocalDateTime.of(2021, Month.NOVEMBER,
            7,00,00,00);

    @Test
    public void fromDemandsHibernateTest() {
        DemandsEntity demandsEntity = new DemandsEntity();
        demandsEntity.setId(ID);
        demandsEntity.setTitle( TITLE);
        demandsEntity.setDescription( DESCRIPTION);
        demandsEntity.setCreationDateTime(CREATION_DATE);
        demandsEntity.setDueDateTime(DUE_DATE);

        DemandsDomain resourceRequestDomain = DemandsEntityDomainMapper.fromDemandsHibernate(demandsEntity);

        assertThat(resourceRequestDomain.getId()).isEqualTo(ID);
        assertThat(resourceRequestDomain.getTitle()).isEqualTo(TITLE);
        assertThat(resourceRequestDomain.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(resourceRequestDomain.getCreationDatTime()).isEqualTo(CREATION_DATE);
        assertThat(resourceRequestDomain.getDueDateTime()).isEqualTo(DUE_DATE);
    }

    @Test
    public void fromDemands() {
        DemandsDomain resourceRequestDomain = new DemandsDomain(ID,TITLE,DESCRIPTION,CREATION_DATE,DUE_DATE);

        DemandsEntity demandsEntity = DemandsEntityDomainMapper.fromDemands(resourceRequestDomain);

        assertThat(demandsEntity.getId()).isEqualTo(ID);
        assertThat(demandsEntity.getTitle()).isEqualTo(TITLE);
        assertThat(demandsEntity.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(demandsEntity.getCreationDateTime()).isEqualTo(CREATION_DATE);
        assertThat(demandsEntity.getDueDateTime()).isEqualTo(DUE_DATE);
    }

    @Test
    public void mapFields() {
        DemandsDomain resourceRequestDomain = new DemandsDomain(ID,TITLE,DESCRIPTION,CREATION_DATE,DUE_DATE);

        DemandsEntity demandsEntity = new DemandsEntity();

        DemandsEntityDomainMapper.mapHibernateFields(resourceRequestDomain, demandsEntity);
        assertThat(demandsEntity.getId()).isEqualTo(ID);
        assertThat(demandsEntity.getTitle()).isEqualTo(TITLE);
        assertThat(demandsEntity.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(demandsEntity.getCreationDateTime()).isEqualTo(CREATION_DATE);
        assertThat(demandsEntity.getDueDateTime()).isEqualTo(DUE_DATE);
    }
}
