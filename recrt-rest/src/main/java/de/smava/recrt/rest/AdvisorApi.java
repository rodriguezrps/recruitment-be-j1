package de.smava.recrt.rest;

import de.smava.recrt.service.AdvisorService;
import de.smava.recrt.service.RecrtServiceException;
import de.smava.recrt.service.resource.AdvisorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 *
 */
@RestController
@RequestMapping(value = "/rest/advisors", produces = {APPLICATION_JSON_VALUE})
public class AdvisorApi {

    @Autowired
    private AdvisorService advisorService;

    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new AdvisorValidator());
    }*/

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET)
    public List<AdvisorResource> get(
            @RequestParam(required = false, value = "hasGroup") final Boolean hasGroup)
            throws RecrtServiceException {

        List<AdvisorResource> advisors = advisorService.getAllAdvisors();

        if (advisors !=null && advisors.size() > 0){
            Map<String, Object> metaData = new HashMap<>();
            metaData.put("count", advisors.size());
            for (AdvisorResource advisor : advisors){
                advisor.setAdditionalInfo(metaData);
            }
        }

        return advisors;
    }

}
