package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class alien
{
    @Id
    int alien_id;
    String alien_name;

    public alien()
    {

    }

    public alien(int alien_id, String alien_name)
    {
        this.alien_id = alien_id;
        this.alien_name = alien_name;
    }

    public int getAlien_id() {
        return alien_id;
    }

    public void setAlien_id(int alien_id) {
        this.alien_id = alien_id;
    }

    public String getAlien_name() {
        return alien_name;
    }

    public void setAlien_name(String alien_name) {
        this.alien_name = alien_name;
    }
}
