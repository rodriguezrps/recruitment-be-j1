package de.smava.recrt.service.impl;

import de.smava.recrt.persistence.model.AppUser;
import de.smava.recrt.persistence.model.BankAccount;
import de.smava.recrt.persistence.repository.AppUserRepository;
import de.smava.recrt.persistence.repository.BankAccountRepository;
import de.smava.recrt.service.BankAccountService;
import de.smava.recrt.service.RecrtServiceException;
import de.smava.recrt.service.resource.AppUserResource;
import de.smava.recrt.service.resource.BankAccountResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public List<BankAccountResource> getByAppUser(String appUserName) throws RecrtServiceException {
        List<BankAccountResource> result = new ArrayList<>();
        AppUser user = appUserRepository.findByUsername(appUserName);

        if (user!=null){
            List<BankAccount> accounts = bankAccountRepository.findByAppUser(user);
            if (accounts!=null && !accounts.isEmpty()){
                for (BankAccount account : accounts){
                    BankAccountResource accountResource = new BankAccountResource();
                    accountResource.setIban(account.getIban());
                    accountResource.setBic(account.getBic());
                    result.add(accountResource);
                }
            }
        }

        return result;
    }
}
