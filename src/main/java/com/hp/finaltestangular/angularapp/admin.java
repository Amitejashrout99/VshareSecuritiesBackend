package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class admin
{
    @Id
    int admin_id;
    String admin_name;
    String admin_email;
    String admin_role;

    public admin()
    {

    }

    public admin(int admin_id, String admin_name, String admin_email, String admin_role) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_email = admin_email;
        this.admin_role = admin_role;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(String admin_role) {
        this.admin_role = admin_role;
    }
}
