package de.smava.recrt.rest.model;

import de.smava.recrt.model.AppUser;

import java.util.List;
import java.util.Set;

public class AppUserResource extends DefaultResource implements AppUser {

    private Long id;

    private String username;

    private String email;

    private List<String> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Set getAppUserRoles() {
        return null;
    }

    @Override
    public void setAppUserRoles(Set appUserRoles) {

    }

    @Override
    public Set getBankAccounts() {
        return null;
    }

    @Override
    public void setBankAccounts(Set bankAccounts) {

    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
