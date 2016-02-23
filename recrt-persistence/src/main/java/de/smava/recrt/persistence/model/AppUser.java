package de.smava.recrt.persistence.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * AppUser Entity.
 * Created by pvitic on 11.05.15.
 */
@Entity
@Table(name = "app_user")
public class AppUser {

	@Id
    @GenericGenerator(name="id_generator" , strategy="increment")
    @GeneratedValue(generator="id_generator")
    private long id;

    private String email;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "appUser")
    private Set<AppUserRole> appUserRoles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private Set<BankAccount> bankAccounts;

    public AppUser() {}

    public AppUser(long id) {
        super();
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AppUserRole> getAppUserRoles() {
        return appUserRoles;
    }

    public void setAppUserRoles(Set<AppUserRole> appUserRoles) {
        this.appUserRoles = appUserRoles;
    }

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
