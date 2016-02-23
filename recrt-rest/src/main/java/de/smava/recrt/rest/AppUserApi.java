package de.smava.recrt.rest;

import de.smava.recrt.service.AppUserService;
import de.smava.recrt.service.RecrtServiceException;
import de.smava.recrt.service.resource.AppUserResource;
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

@RestController
@RequestMapping(value = "/rest/users", produces = {APPLICATION_JSON_VALUE})
public class AppUserApi {

    @Autowired
    private AppUserService appUserService;

    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new AdvisorValidator());
    }*/

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET)
    public List<AppUserResource> getAll(
            @RequestParam(value = "getCount", defaultValue = "false") final Boolean getCount)
            throws RecrtServiceException {

        List<AppUserResource> users = appUserService.getAllAppUsers();

        if (getCount) {
            getCount(users);
        }

        return users;
    }


    private void getCount(List<AppUserResource> users){
        if (users !=null && users.size() > 0){
            Map<String, Object> metaData = new HashMap<>();
            metaData.put("count", users.size());
            for (AppUserResource advisor : users){
                advisor.setAdditionalInfo(metaData);
            }
        }
    }
}
