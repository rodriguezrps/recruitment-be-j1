package de.smava.recrt.service.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import de.smava.recrt.model.AppUser;
import de.smava.recrt.persistence.model.AppUserEntity;
import de.smava.recrt.persistence.repository.AppUserRepository;
import de.smava.recrt.service.AppUserService;

public class AppUserServiceImplTest extends BaseServiceTest {
	
	@Autowired
	AppUserRepository appUserRepository;
	
	@Qualifier("appUserService")
	@Autowired
	AppUserService appUserService;

    @Test
    public void testGetAll() throws Exception {
    	EasyMock.reset(appUserRepository);
    	List<AppUserEntity> mockList = new ArrayList<>();
    	mockList.add(new AppUserEntity("test1"));
    	expect(appUserRepository.findAll()).andReturn(mockList).anyTimes();
    	replay(appUserRepository);
    	List<? extends AppUser> result = appUserService.getAll();
    	assertEquals(result.size(), 1);
    }

    @Test
    public void testGet() throws Exception {
    	EasyMock.reset(appUserRepository);
    	expect(appUserRepository.findOne(anyObject(String.class))).andReturn(new AppUserEntity("test1")).anyTimes();
    	replay(appUserRepository);
    	AppUser result = appUserService.get("test1");
    	assertEquals(result.getUsername(), "test1");
    }
}