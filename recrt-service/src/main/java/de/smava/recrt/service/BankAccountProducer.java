package de.smava.recrt.service;

import de.smava.recrt.service.resource.BankAccountResource;

import java.util.List;

public interface BankAccountProducer {

    void produce(BankAccountResource account) throws RecrtServiceException;

}
