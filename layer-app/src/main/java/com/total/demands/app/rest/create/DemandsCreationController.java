package com.total.demands.app.rest.create;

import com.total.demands.services.DemandsServiceImpl;
import com.total.demands.presentation.DemandsCreationRequest;
import com.total.demands.presentation.DemandsDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(value = "/resources-requests")
public class DemandsCreationController {

    private DemandsServiceImpl demandsServiceImpl;

    public DemandsCreationController(DemandsServiceImpl demandsServiceImpl) {
        this.demandsServiceImpl = demandsServiceImpl;
    }

    @PostMapping(produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DemandsCreationJSONResponse> CreateDemands(@RequestBody DemandsCreationJSONRequest request) throws DemandsDomainException {
        return demandsServiceImpl.createDemands(
                DemandsCreationRequest.createDemandsRequest(request.title, request.description, request.dueDateTimeStamp))
                .map(id -> new DemandsCreationJSONResponse(id));
    }
}
