package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class stock_sales
{
    @Id
    int stock_sale_id;
    String stock_buy_status;
    String stock_sell_status;
    int id;
    int stock_id;
    String stock_bought_on;
    String stock_sold_on;
    int price_bought_for;
    int price_sold_for;
    int no_of_times_bought;
    int no_of_times_sold;

    public stock_sales()
    {

    }

    public stock_sales(int stock_sale_id,
            String stock_buy_status,
            String stock_sell_status,
            int id,
            int stock_id,
            String stock_bought_on,
            String stock_sold_on,
                       int price_bought_for, int price_sold_for,
                       int no_of_times_bought,int no_of_times_sold)
    {
        this.stock_sale_id=stock_sale_id;
        this.stock_buy_status=stock_buy_status;
        this.stock_sell_status=stock_sell_status;
        this.id=id;
        this.stock_id=stock_id;
        this.stock_bought_on=stock_bought_on;
        this.stock_sold_on=stock_sold_on;
        this.price_bought_for= price_bought_for;
        this.price_sold_for=price_sold_for;
        this.no_of_times_bought=no_of_times_bought;
        this.no_of_times_sold=no_of_times_sold;
    }

    public int getStock_sale_id() {
        return stock_sale_id;
    }

    public void setStock_sale_id(int stock_sale_id) {
        this.stock_sale_id = stock_sale_id;
    }

    public String getStock_buy_status() {
        return stock_buy_status;
    }

    public void setStock_buy_status(String stock_buy_status) {
        this.stock_buy_status = stock_buy_status;
    }

    public String getStock_sell_status() {
        return stock_sell_status;
    }

    public void setStock_sell_status(String stock_sell_status) {
        this.stock_sell_status = stock_sell_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_bought_on() {
        return stock_bought_on;
    }

    public void setStock_bought_on(String stock_bought_on) {
        this.stock_bought_on = stock_bought_on;
    }

    public String getStock_sold_on() {
        return stock_sold_on;
    }

    public void setStock_sold_on(String stock_sold_on) {
        this.stock_sold_on = stock_sold_on;
    }

    public int getPrice_bought_for() {
        return price_bought_for;
    }

    public void setPrice_bought_for(int price_bought_for) {
        this.price_bought_for = price_bought_for;
    }

    public int getPrice_sold_for() {
        return price_sold_for;
    }

    public void setPrice_sold_for(int price_sold_for) {
        this.price_sold_for = price_sold_for;
    }

    public int getNo_of_times_bought() {
        return no_of_times_bought;
    }

    public void setNo_of_times_bought(int no_of_times_bought) {
        this.no_of_times_bought = no_of_times_bought;
    }

    public int getNo_of_times_sold() {
        return no_of_times_sold;
    }

    public void setNo_of_times_sold(int no_of_times_sold) {
        this.no_of_times_sold = no_of_times_sold;
    }
}
