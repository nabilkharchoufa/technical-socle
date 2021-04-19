package com.total.demands.demands.infra.repository;

import com.total.demands.domain.DemandsDomain;

public final class DemandsEntityDomainMapper {


    public static DemandsDomain fromDemandsHibernate(DemandsEntity demandsEntity) {
        return new DemandsDomain(demandsEntity.getId(),
                demandsEntity.getTitle(),
                demandsEntity.getDescription(),
                demandsEntity.getCreationDateTime(),
                demandsEntity.getDueDateTime());
    }

    public static DemandsEntity fromDemands(DemandsDomain resourceRequestDomain) {
        DemandsEntity demandsEntity = new DemandsEntity();
        mapHibernateFields(resourceRequestDomain, demandsEntity);
        return demandsEntity;
    }

    public static void mapHibernateFields(DemandsDomain resourceRequestDomain, DemandsEntity demandsEntity) {
        demandsEntity.setId(resourceRequestDomain.getId());
        demandsEntity.setTitle(resourceRequestDomain.getTitle());
        demandsEntity.setDescription(resourceRequestDomain.getDescription());
        demandsEntity.setCreationDateTime(resourceRequestDomain.getCreationDatTime());
        demandsEntity.setDueDateTime(resourceRequestDomain.getDueDateTime());
    }
}
