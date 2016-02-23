package de.smava.recrt.service;

import de.smava.recrt.persistence.model.BankAccount;

import java.util.List;

public interface BankAccountProducer {

    void produce(List<? extends BankAccount> accounts) throws RecrtServiceException;

}
