package de.smava.recrt.service.impl;

import de.smava.recrt.persistence.model.AppUser;
import de.smava.recrt.persistence.repository.AppUserRepository;
import de.smava.recrt.service.AdvisorService;
import de.smava.recrt.service.RecrtServiceException;
import de.smava.recrt.service.resource.AdvisorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class AdvisorServiceImpl implements AdvisorService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AdvisorResource> getAllAdvisors() throws RecrtServiceException {
        List<AdvisorResource> result = new ArrayList<>();
        List<AppUser> appUsers = appUserRepository.findAll();
        for (AppUser appUser : appUsers){
            AdvisorResource advisor = new AdvisorResource();
            advisor.setId(appUser.getId());
            advisor.setUsername(appUser.getUsername());
            result.add(advisor);
        }

        return result;
        // throw new RecrtServiceException(new ErrorResource(HttpStatus.BAD_REQUEST.name(),  "Not implemented!"));
    }
}
