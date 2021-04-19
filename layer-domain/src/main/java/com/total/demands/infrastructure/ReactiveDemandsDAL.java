package com.total.demands.infrastructure;

import com.total.demands.domain.DemandsDomain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveDemandsDAL {

    Flux<DemandsDomain> readDemands();

    Mono<DemandsDomain> readDemands(Long id);

    Mono<Long> create(DemandsDomain resourceRequestDomain);

    void update(DemandsDomain resourceRequestDomain);

    void delete(Long id);
}
