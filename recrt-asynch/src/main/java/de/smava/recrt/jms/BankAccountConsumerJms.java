package de.smava.recrt.jms;

import de.smava.recrt.exception.RecrtServiceException;
import de.smava.recrt.service.BankAccountConsumer;
import de.smava.recrt.service.resource.BankAccountResource;
import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;


/**
 * Created by paul on 21/12/14.
 */
@Service
public class BankAccountConsumerJms implements BankAccountConsumer<BankAccountResource> {

    private static Logger LOG = Logger.getLogger(BankAccountConsumerJms.class);

    @JmsListener(containerFactory = "defaultJmsListenerContainerFactory", destination="bank.account")
    public void consume(BankAccountResource account) throws RecrtServiceException {
        LOG.warn("Received " + account);
    }
}
