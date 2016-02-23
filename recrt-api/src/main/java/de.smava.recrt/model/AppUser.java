package de.smava.recrt.model;

import java.util.Set;

public interface AppUser<T extends AppUserRole, S extends BankAccount> {

    Long getId();

    void setId(Long id);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);

    Set<T> getAppUserRoles();

    void setAppUserRoles(Set<T> appUserRoles);

    Set<S> getBankAccounts();

    void setBankAccounts(Set<S> bankAccounts);
}
