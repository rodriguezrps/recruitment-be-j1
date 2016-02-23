package de.smava.recrt.persistence.repository;

import de.smava.recrt.persistence.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

}
