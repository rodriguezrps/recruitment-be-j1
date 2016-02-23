package de.smava.recrt.rest.model;

import de.smava.recrt.model.AppUser;
import de.smava.recrt.model.BankAccount;

public class BankAccountResource extends DefaultResource implements BankAccount {

    String iban;

    String bic;

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

    @Override
    public AppUser getAppUser() {
        return null;
    }

    @Override
    public void setAppUser(AppUser appUser) {

    }
}
