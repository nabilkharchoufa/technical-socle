package com.total.demands.mapper;

import com.total.demands.domain.DemandsDomain;
import com.total.demands.presentation.ReadDemandsResponse;

public final class DemandsDomainResponseMapper {
    public static ReadDemandsResponse fromDemandsDomain(DemandsDomain resourceRequestDomain) {
        return new ReadDemandsResponse(
                resourceRequestDomain.getId(),
                resourceRequestDomain.getTitle(),
                resourceRequestDomain.getDescription(),
                resourceRequestDomain.getCreationDatTime(),
                resourceRequestDomain.getDueDateTime());
    }

    public static DemandsDomain fromReadDemandsResponse(ReadDemandsResponse readDemandsResponse) {
        return new DemandsDomain(readDemandsResponse.getId(), readDemandsResponse.getTitle(),
                readDemandsResponse.getDescription(), readDemandsResponse.getCreationDatTime(), readDemandsResponse.getDueDateTime());
    }
}
