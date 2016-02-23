package de.smava.recrt.service;

import de.smava.recrt.service.resource.AppUserResource;
import de.smava.recrt.service.resource.BankAccountResource;

import java.util.List;

public interface BankAccountService {

    List<BankAccountResource> getByAppUser(AppUserResource appUser) throws RecrtServiceException;
}
