package de.smava.recrt.persistence.repository;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import de.smava.recrt.persistence.config.PersistenceConfig;
import de.smava.recrt.persistence.model.AppUserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = PersistenceConfig.class)
public class AppUserRepositoryTest {

	@Autowired
	AppUserRepository appUserRepository;
	
    @Test
    public void testSave() throws Exception {
    	AppUserEntity user = new AppUserEntity("testuser");
    	user.setEmail("testuser@test.com");
    	user.setPassword("1234");
    	appUserRepository.save(user);
    	AppUserEntity result = appUserRepository.findOne("testuser");
        assertEquals(result.getUsername(), "testuser");
    }

    @Test
    public void testFindOne() throws Exception {
    	AppUserEntity result = appUserRepository.findOne("user1");
        assertEquals(result.getEmail(), "user1@smava.de");
    }

    @Test
    public void testDelete() throws Exception {
    	AppUserEntity user = new AppUserEntity("testuser");
    	user.setEmail("testuser@test.com");
    	user.setPassword("1234");
    	appUserRepository.save(user);
    	AppUserEntity result = appUserRepository.findOne("testuser");
        assertEquals(result.getUsername(), "testuser");
    	appUserRepository.delete("testuser");
    	assertNull(appUserRepository.findOne("testuser"));
    }

}