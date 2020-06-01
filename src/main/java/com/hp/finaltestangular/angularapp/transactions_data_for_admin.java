package com.hp.finaltestangular.angularapp;

import java.util.List;

public class transactions_data_for_admin
{
    String stock_name;
    stock stock_basic_data;
    List<user> customers_basic_data;
    List<user_kyc_data> customer_kyc_data;
    int total_investment_made;
    int total_returns_made;
    int no_of_times_bought;
    int no_of_times_sold;
    List<stock_reviews> stock_review_data;

    public transactions_data_for_admin()
    {

    }

    public transactions_data_for_admin(String stock_name, stock stock_basic_data, List<user> customers_basic_data, List<user_kyc_data> customer_kyc_data, int total_investment_made, int total_returns_made, int no_of_times_bought, int no_of_times_sold, List<stock_reviews> stock_review_data) {
        this.stock_name = stock_name;
        this.stock_basic_data = stock_basic_data;
        this.customers_basic_data = customers_basic_data;
        this.customer_kyc_data = customer_kyc_data;
        this.total_investment_made = total_investment_made;
        this.total_returns_made = total_returns_made;
        this.no_of_times_bought = no_of_times_bought;
        this.no_of_times_sold = no_of_times_sold;
        this.stock_review_data = stock_review_data;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }


    public List<user_kyc_data> getCustomer_kyc_data() {
        return customer_kyc_data;
    }

    public void setCustomer_kyc_data(List<user_kyc_data> customer_kyc_data) {
        this.customer_kyc_data = customer_kyc_data;
    }

    public int getTotal_investment_made() {
        return total_investment_made;
    }

    public void setTotal_investment_made(int total_investment_made) {
        this.total_investment_made = total_investment_made;
    }

    public int getTotal_returns_made() {
        return total_returns_made;
    }

    public void setTotal_returns_made(int total_returns_made) {
        this.total_returns_made = total_returns_made;
    }

    public List<user> getCustomers_basic_data() {
        return customers_basic_data;
    }

    public void setCustomers_basic_data(List<user> customers_basic_data) {
        this.customers_basic_data = customers_basic_data;
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

    public List<stock_reviews> getStock_review_data() {
        return stock_review_data;
    }

    public void setStock_review_data(List<stock_reviews> stock_review_data) {
        this.stock_review_data = stock_review_data;
    }

    public stock getStock_basic_data() {
        return stock_basic_data;
    }

    public void setStock_basic_data(stock stock_basic_data) {
        this.stock_basic_data = stock_basic_data;
    }
}
