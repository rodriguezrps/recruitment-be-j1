package de.smava.recrt.service;

import de.smava.recrt.exception.RecrtServiceException;
import de.smava.recrt.model.BankAccount;

import java.util.List;

public interface BankAccountService<T extends BankAccount> {

    List<T> getByAppUser(String appUserName) throws RecrtServiceException;

    T create(T account) throws RecrtServiceException;
}
