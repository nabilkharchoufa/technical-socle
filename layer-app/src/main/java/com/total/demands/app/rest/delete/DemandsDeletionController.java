package com.total.demands.app.rest.delete;

import com.total.demands.services.DemandsServiceImpl;
import com.total.demands.presentation.DemandsDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/resources-requests")
public class DemandsDeletionController {

    private DemandsServiceImpl demandsServiceImpl;

    public DemandsDeletionController(DemandsServiceImpl demandsServiceImpl) {
        this.demandsServiceImpl = demandsServiceImpl;
    }

    @RequestMapping(value = "{resourceRequestId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Void> deleteDemands(@PathVariable(value = "resourceRequestId") Long resourceRequestId) throws DemandsDomainException {
        demandsServiceImpl.deleteDemands(resourceRequestId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
