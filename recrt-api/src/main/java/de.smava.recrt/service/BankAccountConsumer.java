package de.smava.recrt.service;

import de.smava.recrt.exception.RecrtServiceException;
import de.smava.recrt.model.BankAccount;

public interface BankAccountConsumer<T extends BankAccount> {

    void consume(T account) throws RecrtServiceException;

}
