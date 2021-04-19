package com.total.demands.demands.infra.repository;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.total.demands.domain.DemandsDomain;
import com.total.demands.infrastructure.ReactiveDemandsDAL;

/**
 * Reactive repository implementation
 *
 * @author nkh
 */
@Slf4j
@NoArgsConstructor
public class ReactiveDemandsDALImpl implements ReactiveDemandsDAL {

    @Autowired
    private ReactiveDemandsRepository reactiveDemandsRepository;

    @Override
    public Flux<DemandsDomain> readDemands() {
        log.debug("Infra Layer : Find all demands from database");
        return reactiveDemandsRepository.findAll()
                .map(DemandsEntityDomainMapper::fromDemandsHibernate);
    }

    @Override
    public Mono<DemandsDomain> readDemands(Long id) {
        return reactiveDemandsRepository.findById(id)
                .map(rq -> new DemandsDomain(rq.getId(), rq.getTitle(), rq.getDescription(), rq.getCreationDateTime(), rq.getDueDateTime()));
    }

    @Override
    public Mono<Long> create(DemandsDomain resourceRequestDomain) {
        return reactiveDemandsRepository.save(DemandsEntityDomainMapper.fromDemands(resourceRequestDomain))
                .map(DemandsEntity::getId);
    }

    @Override
    public void update(DemandsDomain resourceRequestDomain) {
        reactiveDemandsRepository.save(DemandsEntityDomainMapper.fromDemands(resourceRequestDomain));
    }

    @Override
    public void delete(Long id) {
        reactiveDemandsRepository.deleteById(id);
    }
}
