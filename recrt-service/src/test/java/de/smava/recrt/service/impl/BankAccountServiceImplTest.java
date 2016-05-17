package de.smava.recrt.service.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import de.smava.recrt.model.BankAccount;
import de.smava.recrt.persistence.model.AppUserEntity;
import de.smava.recrt.persistence.model.BankAccountEntity;
import de.smava.recrt.persistence.repository.AppUserRepository;
import de.smava.recrt.persistence.repository.BankAccountRepository;
import de.smava.recrt.service.BankAccountService;

public class BankAccountServiceImplTest extends BaseServiceTest {

	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@Qualifier("bankAccountPersistenceService")
	@Autowired
	BankAccountService bankAccountService;
	
	@Autowired
	AppUserRepository appUserRepository;
	
    @Test
    public void testGetByAppUser() throws Exception {
    	EasyMock.reset(appUserRepository, bankAccountRepository);
    	expect(appUserRepository.findOne(anyObject(String.class))).andReturn(new AppUserEntity("test1")).once();
    	replay(appUserRepository);
    	List<BankAccountEntity> mockList = new ArrayList<>();
    	mockList.add(new BankAccountEntity());
    	expect(bankAccountRepository.findByAppUser(anyObject(AppUserEntity.class))).andReturn(mockList).once();
    	replay(bankAccountRepository);
    	List<? extends BankAccount> result = bankAccountService.getByAppUser("test1");
    	assertEquals(result.size(), 1);
    }

    @Test
    public void testCreate() throws Exception {
    	EasyMock.reset(appUserRepository, bankAccountRepository);
		expect(appUserRepository.findOne(anyObject(String.class))).andReturn(new AppUserEntity("test1")).once();
    	replay(appUserRepository);
		expect(bankAccountRepository.save(anyObject(BankAccountEntity.class))).andReturn(new BankAccountEntity()).once();
    	replay(bankAccountRepository);
		BankAccount bankAccount = bankAccountService.create(new BankAccountEntity("", "", new AppUserEntity("test1")));
    	assertNotNull(bankAccount);
    }
}