package de.smava.recrt.model;

public interface AppUserRole<T extends AppUser> {

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    T getAppUser();

    void setAppUser(T appUser);
}
