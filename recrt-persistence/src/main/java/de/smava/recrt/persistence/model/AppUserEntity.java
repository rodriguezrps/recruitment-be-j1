package de.smava.recrt.persistence.model;

import de.smava.recrt.model.AppUser;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * AppUser Entity.
 * Created by pvitic on 11.05.15.
 */
@Entity
@Table(name = "app_user")
public class AppUserEntity implements AppUser<AppUserRoleEntity, BankAccountEntity> {

	@Id
    @GenericGenerator(name="id_generator" , strategy="increment")
    @GeneratedValue(generator="id_generator")
    private Long id;

    private String email;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "appUser")
    private Set<AppUserRoleEntity> appUserRoles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private Set<BankAccountEntity> bankAccounts;

    public AppUserEntity() {}

    public AppUserEntity(long id) {
        super();
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<AppUserRoleEntity> getAppUserRoles() {
        return appUserRoles;
    }

    public void setAppUserRoles(Set<AppUserRoleEntity> appUserRoles) {
        this.appUserRoles = appUserRoles;
    }

    public Set<BankAccountEntity> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccountEntity> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
