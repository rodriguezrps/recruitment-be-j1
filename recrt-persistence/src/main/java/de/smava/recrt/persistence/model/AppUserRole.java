package de.smava.recrt.persistence.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by pvitic on 04.12.15.
 */
@Entity
@Table(name = "app_user_role")
public class AppUserRole {

    @Id
    @GenericGenerator(name="id_generator" , strategy="increment")
    @GeneratedValue(generator="id_generator")
    private long id;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    @Column(name = "name")
    private String name;

    public AppUserRole() {}

    public AppUserRole(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
