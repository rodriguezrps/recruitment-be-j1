package de.smava.recrt.service;

public interface BankAccountConsumer {

    void consume(String account) throws RecrtServiceException;

}
