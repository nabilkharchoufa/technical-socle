package com.total.demands.demands.infra.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveDemandsRepository extends ReactiveCrudRepository<DemandsEntity, Long> {
}
