package de.smava.recrt.jms.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import javax.jms.Session;

/**
 * Created by paul on 21/12/14.
 */
@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public JmsTemplate getJmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestination(new ActiveMQTopic("bank.account"));
        template.setExplicitQosEnabled(true);
        template.setDeliveryPersistent(false);
        template.setTimeToLive(60000);
        template.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(true);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConcurrency("1");
        return factory;
    }

    private ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("vm://localhost");
        return factory;
    }

}
