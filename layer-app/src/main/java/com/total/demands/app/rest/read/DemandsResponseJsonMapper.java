package com.total.demands.app.rest.read;

import com.total.demands.presentation.ReadDemandsResponse;

public final class DemandsResponseJsonMapper {
    public static DemandsDetailJSONResponse fromReadDemandsResponse(ReadDemandsResponse readDemandsResponse) {
        return new DemandsDetailJSONResponse(
                readDemandsResponse.getId(),
                readDemandsResponse.getTitle(),
                readDemandsResponse.getDescription(),
                readDemandsResponse.getCreationDatTime(),
                readDemandsResponse.getDueDateTime());
    }
}
