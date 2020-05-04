package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface stock_watchlist_repo extends JpaRepository<stock_watchlist,Integer>
{
    @Transactional
    @Modifying
    @Query("delete from stock_watchlist where watchlist_id =:id")
    void deleteByWatchlistId(@Param("id") int watchlist_id);

    @Query("from stock_watchlist  where stock_id=:stock_id")
    stock_watchlist findWaitlistStatus(@Param("stock_id") int stock_id);
}
