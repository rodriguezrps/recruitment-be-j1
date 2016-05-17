package de.smava.recrt.service.impl;

import org.easymock.EasyMock;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import de.smava.recrt.persistence.repository.AppUserRepository;
import de.smava.recrt.persistence.repository.AppUserRoleRepository;
import de.smava.recrt.persistence.repository.BankAccountRepository;
import de.smava.recrt.service.config.CachingConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {CachingConfig.class})
public abstract class BaseServiceTest {

	@Configuration
    static class TestConfig {

        @Bean
        public AppUserRoleRepository getAppUserRoleRepository() {
            return EasyMock.mock(AppUserRoleRepository.class);
        }

        @Bean
        public AppUserRepository getAppUserRepository() {
            return EasyMock.mock(AppUserRepository.class);
        }

        @Bean
        public BankAccountRepository getBankAccountRepository() {
            return EasyMock.createStrictMock(BankAccountRepository.class);
        }
        
    }
	
}
