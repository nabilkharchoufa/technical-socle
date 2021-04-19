package com.total.demands.app.rest.update;

import com.total.demands.services.DemandsServiceImpl;
import com.total.demands.presentation.DemandsDomainException;
import com.total.demands.presentation.DemandsUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/resources-requests")
public class DemandsUpdateController {

    private DemandsServiceImpl demandsServiceImpl;

    public DemandsUpdateController(DemandsServiceImpl demandsServiceImpl) {
        this.demandsServiceImpl = demandsServiceImpl;
    }

    @RequestMapping(value = "{resourceRequestId}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Void> updateDemands(@PathVariable(value = "resourceRequestId") Long resourceRequestId,
                                           @RequestBody DemandsUpdateJSONRequest request) throws DemandsDomainException {
        demandsServiceImpl.updateDemands(DemandsUpdateRequest.factory(resourceRequestId, request.title, request.description, request.dueDateTimeStamp));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
