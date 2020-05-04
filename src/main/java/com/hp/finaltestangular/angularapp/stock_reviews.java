package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class stock_reviews
{
    @Id
    int stock_review_id;
    int stock_id;
    String stock_review;
    int id;
    String submitted_on;
    int rating;

    public stock_reviews() {

    }

    public stock_reviews(int stock_review_id,
            int stock_id,
            String stock_review,
            int id,
            String submitted_on,
            int rating)
    {
        this.stock_review_id=stock_review_id;
        this.stock_id=stock_id;
        this.stock_review=stock_review;
        this.id=id;
        this.submitted_on=submitted_on;
        this.rating=rating;
    }

    public int getStock_review_id() {
        return stock_review_id;
    }

    public void setStock_review_id(int stock_review_id) {
        this.stock_review_id = stock_review_id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_review() {
        return stock_review;
    }

    public void setStock_review(String stock_review) {
        this.stock_review = stock_review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubmitted_on() {
        return submitted_on;
    }

    public void setSubmitted_on(String submitted_on) {
        this.submitted_on = submitted_on;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
