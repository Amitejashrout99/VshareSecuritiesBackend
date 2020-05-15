package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class admin_credentials
{
    @Id
    String admin_username;
    String admin_password;

    public admin_credentials()
    {

    }

    public admin_credentials(String admin_username, String admin_password)
    {
        this.admin_username = admin_username;
        this.admin_password = admin_password;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
}
