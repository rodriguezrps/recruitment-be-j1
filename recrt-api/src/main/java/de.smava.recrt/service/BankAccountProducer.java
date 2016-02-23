package de.smava.recrt.service;

import de.smava.recrt.exception.RecrtServiceException;
import de.smava.recrt.model.BankAccount;

public interface BankAccountProducer<T extends BankAccount> {

    void produce(T account) throws RecrtServiceException;

}
