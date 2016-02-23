package de.smava.recrt.service;

import de.smava.recrt.service.resource.AppUserResource;
import de.smava.recrt.service.resource.BankAccountResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BankAccountService {

    List<BankAccountResource> getByAppUser(String appUserName) throws RecrtServiceException;

    BankAccountResource create(BankAccountResource account) throws RecrtServiceException;
}
