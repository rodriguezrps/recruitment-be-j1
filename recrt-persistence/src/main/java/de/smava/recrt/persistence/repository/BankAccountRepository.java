package de.smava.recrt.persistence.repository;

import de.smava.recrt.persistence.model.AppUser;
import de.smava.recrt.persistence.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    List<BankAccount> findByAppUser(AppUser appUser);
}
