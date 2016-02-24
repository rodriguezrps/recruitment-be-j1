package de.smava.recrt.jms;

import de.smava.recrt.exception.RecrtError;
import de.smava.recrt.exception.RecrtServiceException;
import de.smava.recrt.model.BankAccount;
import de.smava.recrt.service.BankAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bankAccountJmsProducer")
public class BankAccountJmsProducer implements BankAccountService {

    private static Logger LOG = Logger.getLogger(BankAccountJmsProducer.class);

    @Autowired
    private JmsTemplate template;

    @Override
    public List<? extends BankAccount> getByAppUser(String appUserName) throws RecrtServiceException {
        throw new RecrtServiceException(new RecrtError("No asynchronous service to get bank account by user."));
    }

    @Override
    public BankAccount create(BankAccount account) throws RecrtServiceException {
        template.convertAndSend(account);
        return null;
    }
}
