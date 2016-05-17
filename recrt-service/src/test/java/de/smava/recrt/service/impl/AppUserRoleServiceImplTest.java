package de.smava.recrt.service.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.smava.recrt.model.AppUserRole;
import de.smava.recrt.persistence.model.AppUserEntity;
import de.smava.recrt.persistence.model.AppUserRoleEntity;
import de.smava.recrt.persistence.repository.AppUserRoleRepository;
import de.smava.recrt.service.AppUserRoleService;

public class AppUserRoleServiceImplTest extends BaseServiceTest {

	@Autowired
	AppUserRoleRepository appUserRoleRepository;
	
	@Autowired
	AppUserRoleService appUserRoleService;
	
    @Test
    public void testGetByAppUser() throws Exception {
    	List<AppUserRoleEntity> mockList = new ArrayList<>();
    	mockList.add(new AppUserRoleEntity());
    	expect(appUserRoleRepository.findByKeyAppUser(anyObject(AppUserEntity.class))).andReturn(mockList);
    	replay(appUserRoleRepository);
    	List<? extends AppUserRole> result = appUserRoleService.getByAppUser(new AppUserEntity());
    	assertEquals(result.size(), 1);
    }
}