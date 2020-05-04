package com.hp.finaltestangular.angularapp;

import java.util.List;

public class stock_research_dto
{
    int total_investment_made;
    int total_returns_of_stock;
    List<Integer> all_customers_ids;
    int profit_margin;
    int no_of_times_bought;
    int no_of_times_sold;
    List<stock_reviews>all_reviews_available;

    public stock_research_dto()
    {

    }

    public stock_research_dto(int total_investment_made, int total_returns_of_stock, List<Integer> all_customers_ids, int profit_margin, int no_of_times_bought, int no_of_times_sold, List<stock_reviews> all_reviews_available) {
        this.total_investment_made = total_investment_made;
        this.total_returns_of_stock = total_returns_of_stock;
        this.all_customers_ids = all_customers_ids;
        this.profit_margin = profit_margin;
        this.no_of_times_bought = no_of_times_bought;
        this.no_of_times_sold = no_of_times_sold;
        this.all_reviews_available = all_reviews_available;
    }

    public int getTotal_investment_made() {
        return total_investment_made;
    }

    public void setTotal_investment_made(int total_investment_made) {
        this.total_investment_made = total_investment_made;
    }

    public int getTotal_returns_of_stock() {
        return total_returns_of_stock;
    }

    public void setTotal_returns_of_stock(int total_returns_of_stock) {
        this.total_returns_of_stock = total_returns_of_stock;
    }

    public List<Integer> getAll_customers_ids() {
        return all_customers_ids;
    }

    public void setAll_customers_ids(List<Integer> all_customers_ids) {
        this.all_customers_ids = all_customers_ids;
    }

    public int getProfit_margin() {
        return profit_margin;
    }

    public void setProfit_margin(int profit_margin) {
        this.profit_margin = profit_margin;
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

    public List<stock_reviews> getAll_reviews_available() {
        return all_reviews_available;
    }

    public void setAll_reviews_available(List<stock_reviews> all_reviews_available) {
        this.all_reviews_available = all_reviews_available;
    }
}
