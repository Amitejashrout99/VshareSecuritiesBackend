package com.hp.finaltestangular.angularapp;

public class stock_recommendations_dto
{
    String stock_name;
    int times_purchased;

    public stock_recommendations_dto()
    {

    }

    public stock_recommendations_dto(String stock_name, int times_purchased) {
        this.stock_name = stock_name;
        this.times_purchased = times_purchased;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public int getTimes_purchased() {
        return times_purchased;
    }

    public void setTimes_purchased(int times_purchased) {
        this.times_purchased = times_purchased;
    }
}
