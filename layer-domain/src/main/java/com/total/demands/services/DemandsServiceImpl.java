package com.total.demands.services;

import com.total.demands.domain.DemandsDomain;
import com.total.demands.domain.validators.ValidationError;
import com.total.demands.infrastructure.ReactiveDemandsDAL;
import com.total.demands.mapper.DemandsDomainResponseMapper;
import com.total.demands.presentation.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
public class DemandsServiceImpl implements DemandsService {

    private ReactiveDemandsDAL reactiveDemandsDAL;

    public DemandsServiceImpl(ReactiveDemandsDAL reactiveDemandsDAL) {
        this.reactiveDemandsDAL = reactiveDemandsDAL;
    }

    @Transactional
    public Flux<ReadDemandsResponse> readDemands() {
        Flux<ReadDemandsResponse> resourceRequests = reactiveDemandsDAL.readDemands()
                .map(demandsDomain -> DemandsDomainResponseMapper.fromDemandsDomain(demandsDomain));

        return resourceRequests;
    }

    @Transactional
    public Mono<Long> createDemands(DemandsCreationRequest request) {
        DemandsDomain resourceRequestDomain = new DemandsDomain(request.title, request.description, request.dueDateTimeStamp);
        return reactiveDemandsDAL.create(resourceRequestDomain);
    }

    @Transactional
    public Mono<ReadDemandsResponse> readDemands(Long id) {
        return reactiveDemandsDAL.readDemands(id).map(DemandsDomain::buildDemandsResponse);
    }

    @Transactional
    public void updateDemands(DemandsUpdateRequest request) throws DemandsDomainException {

        Mono<DemandsDomain> resourceRequestOpt = reactiveDemandsDAL.readDemands(request.id);

        Mono<DemandsDomain> modified = resourceRequestOpt.map(t -> t.updateFromUpdateRequest(request)).switchIfEmpty(Mono.error(() ->
                new DemandsDomainException(Collections.
                        singletonList(new DemandsError(ValidationError.INVALID_REQUEST_RESOURCE_NUMBER.code, "id", ValidationError.INVALID_REQUEST_RESOURCE_NUMBER.message)))));

        modified.map(mod -> {
            reactiveDemandsDAL.update(mod);
            return mod;
        });
    }

    public void deleteDemands(Long id) throws DemandsDomainException {
        Mono<DemandsDomain> resourceRequestOpt = reactiveDemandsDAL.readDemands(id);
        resourceRequestOpt.map((th) -> {
            reactiveDemandsDAL.delete(id);
            return id;
        }).switchIfEmpty(Mono.error(() ->
                new DemandsDomainException(Collections.
                        singletonList(new DemandsError(ValidationError.INVALID_REQUEST_RESOURCE_NUMBER.code, "id", ValidationError.INVALID_REQUEST_RESOURCE_NUMBER.message)))));
    }
}
