package de.smava.recrt.persistence.model;

import de.smava.recrt.model.AppUser;
import de.smava.recrt.model.BankAccount;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccountEntity implements BankAccount<AppUserEntity> {

    @Id
    @Column(name = "iban")
    String iban;

    @Column(name = "bic")
    String bic;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUserEntity appUser;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public AppUserEntity getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUserEntity appUser) {
        this.appUser = appUser;
    }
}
