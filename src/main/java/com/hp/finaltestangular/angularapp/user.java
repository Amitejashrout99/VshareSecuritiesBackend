package com.hp.finaltestangular.angularapp;

//import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user
{
    @Id
    int id;
    String name;
    int age;
    String address;
    String gender;
    String nationality;
    String kyc_status;

    public user()
    {

    }

    public user(int id, String name, int age, String address, String gender, String nationality, String kyc_status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.nationality = nationality;
        this.kyc_status=kyc_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getKyc_status() {
        return kyc_status;
    }

    public void setKyc_status(String kyc_status) {
        this.kyc_status = kyc_status;
    }
}
