package de.smava.recrt.persistence.repository;

import de.smava.recrt.persistence.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = "SELECT * FROM ACCOUNT A " +
            "JOIN ACCOUNT_ROLE R ON A.ID = R.ACCOUNT_ID " +
            "WHERE R.NAME = 'ROLE_USER'",
            nativeQuery = true)
    List<AppUser> findAllUsers();
}
