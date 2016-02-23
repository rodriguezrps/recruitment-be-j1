package de.smava.recrt.service;

import de.smava.recrt.service.resource.AppUserResource;

import java.util.List;

/**
 *
 */
public interface AppUserService {

    List<AppUserResource> getAllAppUsers() throws RecrtServiceException;

    AppUserResource getByUsername(String username);

}
