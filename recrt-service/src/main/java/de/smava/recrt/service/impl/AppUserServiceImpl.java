package de.smava.recrt.service.impl;

import de.smava.recrt.persistence.model.AppUser;
import de.smava.recrt.persistence.model.AppUserRole;
import de.smava.recrt.persistence.repository.AppUserRepository;
import de.smava.recrt.service.AppUserService;
import de.smava.recrt.service.RecrtServiceException;
import de.smava.recrt.service.resource.AppUserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUserResource> getAllAppUsers() throws RecrtServiceException {
        List<AppUserResource> result = new ArrayList<>();
        List<AppUser> appUsers = appUserRepository.findAll();

        for (AppUser appUser : appUsers){
            AppUserResource user = new AppUserResource();
            user.setId(appUser.getId());
            user.setUsername(appUser.getUsername());
            user.setEmail(appUser.getEmail());
            result.add(user);
        }

        return result;
        // throw new RecrtServiceException(new ErrorResource(HttpStatus.BAD_REQUEST.name(),  "Not implemented!"));
    }

    @Override
    @Transactional
    public AppUserResource getByUsername(String username) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null){
            return null;
        }

        AppUserResource result = new AppUserResource();
        result.setId(appUser.getId());
        result.setUsername(appUser.getUsername());
        result.setEmail(appUser.getEmail());

        Set<AppUserRole> roles = appUser.getAppUserRoles();

        if (roles !=null && !roles.isEmpty()){
            List<String> resourceRoles = new ArrayList<>();
            for (AppUserRole role : roles){
                resourceRoles.add(role.getName());
            }
            result.setRoles(resourceRoles);
        }

        return result;
    }
}
