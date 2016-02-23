package de.smava.recrt.service;

import de.smava.recrt.service.resource.BankAccountResource;

public interface BankAccountConsumer {

    void consume(BankAccountResource account) throws RecrtServiceException;

}
