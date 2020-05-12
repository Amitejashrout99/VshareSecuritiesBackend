package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user_kyc_data
{
    @Id
    int id;
    String father_name;
    String mother_name;
    String dob;
    String occupation;
    String passport_number;
    String expiry_date;
    String aadhar_card_number;
    String pan_card_number;
    String email_id;
    String mobile_number;
    String city_name;
    String state_name;
    String country_name;
    int pin_code;

    public user_kyc_data()
    {

    }


    public user_kyc_data(int id, String father_name, String mother_name, String dob, String occupation, String passport_number, String expiry_date, String aadhar_card_number, String pan_card_number, String email_id, String mobile_number, String city_name, String state_name, String country_name, int pin_code) {
        this.id = id;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.dob = dob;
        this.occupation = occupation;
        this.passport_number = passport_number;
        this.expiry_date = expiry_date;
        this.aadhar_card_number = aadhar_card_number;
        this.pan_card_number = pan_card_number;
        this.email_id = email_id;
        this.mobile_number = mobile_number;
        this.city_name = city_name;
        this.state_name = state_name;
        this.country_name = country_name;
        this.pin_code = pin_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getAadhar_card_number() {
        return aadhar_card_number;
    }

    public void setAadhar_card_number(String aadhar_card_number) {
        this.aadhar_card_number = aadhar_card_number;
    }

    public String getPan_card_number() {
        return pan_card_number;
    }

    public void setPan_card_number(String pan_card_number) {
        this.pan_card_number = pan_card_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public int getPin_code() {
        return pin_code;
    }

    public void setPin_code(int pin_code) {
        this.pin_code = pin_code;
    }
}
