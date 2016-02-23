package de.smava.recrt.persistence.model;

import de.smava.recrt.model.AppUser;
import de.smava.recrt.model.AppUserRole;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "app_user_role")
public class AppUserRoleEntity implements AppUserRole<AppUserEntity> {

    @Id
    @GenericGenerator(name="id_generator" , strategy="increment")
    @GeneratedValue(generator="id_generator")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUserEntity appUser;

    @Column(name = "name")
    private String name;

    public AppUserRoleEntity() {}

    public AppUserRoleEntity(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUserEntity getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUserEntity appUser) {
        this.appUser = appUser;
    }
}
