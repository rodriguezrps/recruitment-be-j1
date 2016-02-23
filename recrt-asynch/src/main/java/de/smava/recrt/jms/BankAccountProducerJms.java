package de.smava.recrt.jms;

import de.smava.recrt.service.BankAccountProducer;
import de.smava.recrt.service.RecrtServiceException;
import de.smava.recrt.service.resource.BankAccountResource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service("bankAccountProducerJms")
public class BankAccountProducerJms implements BankAccountProducer {

    private static Logger LOG = Logger.getLogger(BankAccountProducerJms.class);

    @Autowired
    private JmsTemplate template;

    public void produce(BankAccountResource account) throws RecrtServiceException {
        template.convertAndSend(account);
    }
}
