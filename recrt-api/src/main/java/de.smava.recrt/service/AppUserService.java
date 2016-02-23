package de.smava.recrt.service;

import de.smava.recrt.exception.RecrtServiceException;
import de.smava.recrt.model.AppUser;

import java.util.List;

public interface AppUserService<T extends AppUser> {

    List<T> getAllAppUsers() throws RecrtServiceException;

    T getByUsername(String username) throws RecrtServiceException;

}
