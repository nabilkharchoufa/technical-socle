package com.total.demands.app.rest.read;

import com.total.demands.app.rest.exceptions.ResourceNotFoundException;
import com.total.demands.services.DemandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive Rest API to getting demands
 *
 * @author NKH
 */
@RestController
@RequestMapping(value = "/resources-requests")
public class DemandsReadController {

    @Autowired
    private DemandsService demandsService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public Flux<DemandsDetailJSONResponse>  readDemands() {
        return demandsService.readDemands()
                .map(demandsResponse -> DemandsResponseJsonMapper.fromReadDemandsResponse(demandsResponse));
    }

    @GetMapping(value = "{resourceRequestId}", produces = "application/json")
    @ResponseBody
    public Mono<DemandsDetailJSONResponse> readDemands(@PathVariable(value = "resourceRequestId") Long resourceRequestId) throws ResourceNotFoundException {

        return demandsService.readDemands(resourceRequestId)
                .map(demandsResponse -> DemandsResponseJsonMapper.fromReadDemandsResponse(demandsResponse))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException()));
    }
}
