package com.total.demands.services;

import com.total.demands.presentation.DemandsCreationRequest;
import com.total.demands.presentation.DemandsDomainException;
import com.total.demands.presentation.DemandsUpdateRequest;
import com.total.demands.presentation.ReadDemandsResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service to be exposed to app layer
 * @author  NKH
 */
public interface DemandsService {

    public Flux<ReadDemandsResponse> readDemands();

    public Mono<Long> createDemands(DemandsCreationRequest request);

    public Mono<ReadDemandsResponse> readDemands(Long id) ;

    public void updateDemands(DemandsUpdateRequest request) throws DemandsDomainException;

    public void deleteDemands(Long id) throws DemandsDomainException;
}
