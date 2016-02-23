package de.smava.recrt.service.impl;

import de.smava.recrt.exception.RecrtServiceException;
import de.smava.recrt.persistence.model.AppUserEntity;
import de.smava.recrt.persistence.model.BankAccountEntity;
import de.smava.recrt.persistence.repository.AppUserRepository;
import de.smava.recrt.persistence.repository.BankAccountRepository;
import de.smava.recrt.service.BankAccountProducer;
import de.smava.recrt.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService<BankAccountEntity> {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountProducer bankAccountProducer;

    @Override
    @Transactional
    public List<BankAccountEntity> getByAppUser(String appUserName) throws RecrtServiceException {
        AppUserEntity user = appUserRepository.findByUsername(appUserName);
        if (user!=null){
            return bankAccountRepository.findByAppUser(user);
        }

        return new ArrayList<>();
    }

    @Override
    public BankAccountEntity create(BankAccountEntity account) throws RecrtServiceException {
        bankAccountProducer.produce(account);
        return null;
    }
    
}
