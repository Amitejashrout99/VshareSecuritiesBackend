package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface stock_sales_repo extends JpaRepository<stock_sales,Integer>
{
    @Query("from stock_sales where id=:user_id and (stock_sold_on='not_sold' or no_of_times_bought<>no_of_times_sold) ")
    List<stock_sales> findBoughtStocks(@Param("user_id") int userid);

    @Query("from stock_sales where id=:user_id")
    List<stock_sales> findAllBoughtStocks(@Param("user_id") int userid);

    @Query("select stock_id from stock_sales where id=:user_id")
    List<Integer> findAllBoughtStocksIds(@Param("user_id") int user_id);

    @Query("from stock_sales where id= :user_id and stock_sell_status='Yes' ")
    List<stock_sales> findAllSoldStocks(@Param("user_id") int user_id);

    @Query("select coalesce(sum(price_bought_for),0) from stock_sales where stock_id=:stock_id")
    int findTotalInvestmentMade(@Param("stock_id")int stock_id);

    @Query("select coalesce(sum(price_sold_for),0) from stock_sales where stock_id=:stock_id")
    int findTotalReturnsMade(@Param("stock_id") int stock_id);

    @Query("select id from stock_sales where stock_id=:stock_id")
    List<Integer> all_customers_user_ids(@Param("stock_id") int stock_id);

    @Query(value = "select coalesce(sum(no_of_times_bought),0) from stock_sales where stock_id=:stock_id",
            nativeQuery = true)
    int calculateNumberOfTimesStockBought(@Param("stock_id")int stock_id);


    @Query(value="select coalesce(sum(no_of_times_sold),0) from stock_sales where stock_id=:stock_id",
    nativeQuery=true)
    int calculateNumberOfTimesStockSold(@Param("stock_id") int stock_id);

    @Query("select count(stock_sale_id) from stock_sales where stock_id=:stock_id")
    int checkStockBoughtOrNot(@Param("stock_id") int stock_id);

}
