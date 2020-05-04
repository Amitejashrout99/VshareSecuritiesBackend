package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class stock
{
    @Id
    int stock_id;
    String stock_name;
    int stock_quantity;
    int stock_value;
    int stock_present_price;
    int id;

    public stock()
    {

    }

    public stock(int stock_id,
                 String stock_name,
                 int stock_quantity,
                 int stock_value,
                 int stock_present_price,
                 int id)
    {
        this.stock_id=stock_id;
        this.stock_name=stock_name;
        this.stock_quantity=stock_quantity;
        this.stock_value=stock_value;
        this.stock_present_price=stock_present_price;
        this.id=id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public int getStock_value() {
        return stock_value;
    }

    public void setStock_value(int stock_value) {
        this.stock_value = stock_value;
    }

    public int getStock_present_price() {
        return stock_present_price;
    }

    public void setStock_present_price(int stock_present_price) {
        this.stock_present_price = stock_present_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
