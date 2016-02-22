package de.smava.recrt.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @Column(name = "iban")
    String iban;

    @Column(name = "bic")
    String bic;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

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

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
