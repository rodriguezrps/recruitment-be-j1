package de.smava.recrt.persistence.repository;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import de.smava.recrt.persistence.config.PersistenceConfig;
import de.smava.recrt.persistence.model.AppUserRoleEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = PersistenceConfig.class)
public class AppUserRoleRepositoryTest {

	@Autowired
	AppUserRoleRepository appUserRoleRepository;
	
	@Autowired
	AppUserRepository appUserRepository;
	
    @Test
    public void testFindByKeyAppUser() throws Exception {
    	List<AppUserRoleEntity> result = appUserRoleRepository.findByKeyAppUser(appUserRepository.findOne("user1"));
    	assertEquals(1, result.size());
    }
}