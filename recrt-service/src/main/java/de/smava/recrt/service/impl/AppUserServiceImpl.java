package de.smava.recrt.service.impl;

import de.smava.recrt.exception.RecrtServiceException;
import de.smava.recrt.model.AppUser;
import de.smava.recrt.persistence.model.AppUserEntity;
import de.smava.recrt.persistence.repository.AppUserRepository;
import de.smava.recrt.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
public class AppUserServiceImpl implements AppUserService<AppUserEntity> {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUserEntity> getAllAppUsers() throws RecrtServiceException {
        return appUserRepository.findAll();
        // throw new RecrtServiceException(new ErrorResource(HttpStatus.BAD_REQUEST.name(),  "Not implemented!"));
    }

    @Override
    @Transactional
    public AppUserEntity getByUsername(String username) {
        AppUserEntity appUser = appUserRepository.findByUsername(username);
        if (appUser == null){
            return null;
        }

        appUser.getAppUserRoles();
        return appUser;
    }
}
