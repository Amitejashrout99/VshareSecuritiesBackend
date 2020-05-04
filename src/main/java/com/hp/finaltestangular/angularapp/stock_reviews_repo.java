package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface stock_reviews_repo extends JpaRepository<stock_reviews,Integer>
{
    @Query("from stock_reviews where stock_id in :ids")
    List<stock_reviews> findBoughtStockReviews(@Param("ids") List<Integer>bought_stock_ids);


    @Query("from stock_reviews  where stock_id=:stock_id")
    List<stock_reviews> findParticularStockReviews(@Param("stock_id") int stock_id);
}
