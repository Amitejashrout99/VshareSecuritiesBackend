package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class user_reviews_track
{
    @Id
    int review_track_id;
    int stock_id;
    int id;
    int stock_review_id;

    public user_reviews_track()
    {

    }

    public user_reviews_track(int review_track_id,
                              int stock_id,
                              int id,
                              int stock_review_id)
    {
        this.review_track_id=review_track_id;
        this.stock_id=stock_id;
        this.id=id;
        this.stock_review_id=stock_review_id;
    }

    public int getReview_track_id() {
        return review_track_id;
    }

    public void setReview_track_id(int review_track_id) {
        this.review_track_id = review_track_id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock_review_id() {
        return stock_review_id;
    }

    public void setStock_review_id(int stock_review_id) {
        this.stock_review_id = stock_review_id;
    }
}
