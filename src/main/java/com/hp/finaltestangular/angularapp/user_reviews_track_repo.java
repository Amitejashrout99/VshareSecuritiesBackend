package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface user_reviews_track_repo extends JpaRepository<user_reviews_track,Integer>
{
    @Query("select stock_id from user_reviews_track where id =:uid and stock_id in :ids group by stock_id")
    List<Integer> findPendingReviewsByUser(@Param("ids")List<Integer> bought_stock_ids,@Param("uid") int userid);
}
