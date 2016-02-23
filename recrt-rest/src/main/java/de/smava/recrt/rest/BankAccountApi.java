package de.smava.recrt.rest;

import de.smava.recrt.service.AppUserService;
import de.smava.recrt.service.BankAccountService;
import de.smava.recrt.service.RecrtServiceException;
import de.smava.recrt.service.resource.AppUserResource;
import de.smava.recrt.service.resource.BankAccountResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/rest/accounts", produces = {APPLICATION_JSON_VALUE})
public class BankAccountApi {

    @Autowired
    private BankAccountService bankAccountService;

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    public List<BankAccountResource> getAll()
            throws RecrtServiceException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        
        return bankAccountService.getByAppUser(name);

    }
}
