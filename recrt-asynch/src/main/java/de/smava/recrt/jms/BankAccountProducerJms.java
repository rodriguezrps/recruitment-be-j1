package de.smava.recrt.jms;

import de.smava.recrt.persistence.model.BankAccount;
import de.smava.recrt.service.BankAccountProducer;
import de.smava.recrt.service.RecrtServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Date;
import java.util.List;

/**
 * Created by paul on 21/12/14.
 */
@Service("bankAccountProducerJms")
public class BankAccountProducerJms implements BankAccountProducer {

    private static Logger LOG = Logger.getLogger(BankAccountProducerJms.class);

    @Autowired
    private JmsTemplate template;

    public void produce(List<? extends BankAccount> accounts) {
        for (final BankAccount account : accounts) {

            final StringBuilder builder = new StringBuilder();
            builder.append("BankAccount [IBAN:")
                    .append(account.getIban())
                    .append(", BIC:")
                    .append(account.getBic())
                    .append("] sent at: ")
                    .append(new Date());

            try {
                send(builder.toString());
            } catch (JMSException e) {
                throw new RecrtServiceException(e.getMessage());
            }
        }
    }

    private void send(final String payload) throws JMSException{
        template.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(payload);
                LOG.debug("Sending " + payload);
                return message;
            }
        });
    }
}
