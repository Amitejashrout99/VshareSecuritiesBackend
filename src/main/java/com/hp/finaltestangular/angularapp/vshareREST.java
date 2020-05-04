package com.hp.finaltestangular.angularapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Component
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class vshareREST
{
    @Autowired
    usersrepo repo;

    @Autowired
    stockrepo stock_repo;

    @Autowired
    userrepo usrepo;

    @Autowired
    stock_sales_repo stock_sales_repo_object;

    @Autowired
    stock_watchlist_repo stock_watchlist_repo_object;

    @Autowired
    stock_reviews_repo stock_reviews_repo_object;

    @Autowired
    user_reviews_track_repo user_reviews_track_repo_object;

    @Autowired
    forum_main_db_repo forum_main_db_repo_object;

    @Autowired
    forum_answer_db_repo forum_answer_db_repo_object;




    @GetMapping(path="verify_user/{user_name}")
    @ResponseBody
    users verify_user(@PathVariable("user_name")String username)
    {

        users us= repo.find_user(username);
        if(us==null)
        {
            users false_response= new users("","");
            return false_response;
        }
        else
        {
            System.out.println("Hit made");
            return us;
        }

    }

    @GetMapping(path="getAllUsers",produces = {"application/json"})
    @ResponseBody
    List<user> get_all_user()
    {
        List<user> data= usrepo.findAll();
        return data;
    }

    @GetMapping(path="getUserById/{uid}",produces = {"application/json"})
    @ResponseBody
    user get_user_by_id(@PathVariable("uid") int user_id)
    {
        user data= usrepo.findById(user_id).orElse(new user(0," ",0," "," "," ",""));
        return data;
    }

    @GetMapping(path = "allStocks",produces = {"application/json"})
    @ResponseBody
    List<stock> all_stocks_present()
    {
        List<stock> all_stocks= stock_repo.findAll();

        return all_stocks;
    }

    @GetMapping(path="particularStock/{stock_id}", produces = {"application/json"})
    @ResponseBody
    stock get_particular_stock(@PathVariable("stock_id") int id_of_stock)
    {
        stock st= stock_repo.findById(id_of_stock).orElse(new stock(0,"",0,0,0,0));
        return st;
    }

    @GetMapping(path="getUserId/{user_name}",produces = {"application/json"})
    @ResponseBody
    user get_particular_user_id(@PathVariable("user_name") String username)
    {
        user us= usrepo.find_id_of_user(username);
        return us;
    }

    @PostMapping(path="addStockBuy", consumes = {"application/json"})
    @ResponseBody
    stock_sales add_stock_buy(@RequestBody stock_sales stock_buy_object)
    {

        System.out.print(stock_buy_object);
        stock_sales_repo_object.save(stock_buy_object);

        return stock_buy_object;
    }

    @PutMapping(path="updateExistingStocks/{stockid}",produces = {"application/json"})
    @ResponseBody
    stock update_existing_stock(@PathVariable("stockid") int stock_id,@RequestBody stock_sales stock_buy_object)
    {
        return stock_repo.findById(stock_id)
                .map(stock_obj -> {
                    stock_obj.setStock_quantity(stock_obj.getStock_quantity()-stock_buy_object.no_of_times_bought);
                    return stock_repo.save(stock_obj);
                })
                .orElseGet(()->{
                    stock st= new stock(0,"",0,0,0,0);
                    return stock_repo.save(st);
                });
    }

    @PostMapping(path="addStockWatchlist",consumes = {"application/json"})
    @ResponseBody
    stock_watchlist add_stock_to_watchlist(@RequestBody stock_watchlist stock_watchlist_object)
    {
        stock_watchlist_repo_object.save(stock_watchlist_object);

        return stock_watchlist_object;
    }

    @GetMapping(path="checkWatchListStatus/{stock_id}",produces = {"application/json"})
    @ResponseBody
    stock_watchlist check_waitlist_status(@PathVariable("stock_id") int stock_id)
    {
        stock_watchlist obj= stock_watchlist_repo_object.findWaitlistStatus(stock_id);

        return obj;
    }


    @DeleteMapping(path="deleteWatchlistedStock/{watch_id}")
    @ResponseBody
    String deleteWatchlistedStock(@PathVariable("watch_id") int watchlist_id)
    {

        stock_watchlist_repo_object.deleteByWatchlistId(watchlist_id);

        return "Stock has been removed from watchlist";

    }

    @GetMapping(path="allWatchlistedStocks",produces = {"application/json"})
    @ResponseBody
    List<stock_watchlist> all_watchlisted_stocks()
    {
        List<stock_watchlist> all_items= stock_watchlist_repo_object.findAll();

        return all_items;
    }

    @GetMapping(path = "getBoughtStocks/{uid}",produces = {"application/json"})
    @ResponseBody
    List<stock_sales> allBoughtStocks(@PathVariable("uid") int user_id)
    {
        List<stock_sales> boughtStockList = stock_sales_repo_object.findBoughtStocks(user_id);

        return boughtStockList;
    }

    @PutMapping(path="updateStockSaleData/{stock_sale_id}",produces = {"application/json"})
    @ResponseBody
    stock_sales update_stocksale_data(@PathVariable("stock_sale_id") int transaction_id,@RequestBody stock_sales stock_sell_object)
    {
        return stock_sales_repo_object.findById(transaction_id)
                .map(stock_sale_obj -> {
                    //stock_obj.setStock_quantity(stock_obj.getStock_quantity()-stock_buy_object.no_of_times_bought);
                    stock_sale_obj.setStock_sell_status("Yes");
                    stock_sale_obj.setNo_of_times_sold(stock_sell_object.getNo_of_times_sold());
                    stock_sale_obj.setStock_sold_on(stock_sell_object.getStock_sold_on());
                    stock_sale_obj.setPrice_sold_for(stock_sell_object.getPrice_sold_for());

                    return stock_sales_repo_object.save(stock_sale_obj);
                })
                .orElseGet(()->{
                    stock_sales st= new stock_sales(0," ","",0,0,"","",0,0,0,0);
                    return stock_sales_repo_object.save(st);
                });
    }

    @GetMapping(path="getParticularStockSaleData/{stock_sale_id}",produces = {"application/json"})
    @ResponseBody
    stock_sales getParticularSellData(@PathVariable("stock_sale_id") int transaction_id)
    {
       stock_sales data= stock_sales_repo_object.findById(transaction_id).orElse(new stock_sales(0," ","",0,0,"","",0,0,0,0));
       return data;
    }

    @GetMapping(path ="getAllBoughtStocks/{user_id}",produces = {"application/json"})
    @ResponseBody
    List<stock_sales> findAllBoughtStocks(@PathVariable("user_id") int userid)
    {
        List<stock_sales> all_bought_stocks = stock_sales_repo_object.findAllBoughtStocks(userid);

        return  all_bought_stocks;
    }

    @GetMapping(path="getAllSoldStocks/{user_id}",produces = {"application/json"})
    @ResponseBody
    List<stock_sales> findAllSoldStocks(@PathVariable("user_id") int userid)
    {
        List<stock_sales> all_sold_stocks = stock_sales_repo_object.findAllSoldStocks(userid);

        return all_sold_stocks;
    }

    @GetMapping(path="BoughtStockReviews/{bought_stock_ids}",produces = {"application/json"})
    @ResponseBody
    List<stock_reviews>findBoughtStockReviews(@PathVariable("bought_stock_ids") List<Integer> stock_ids)
    {
        List<stock_reviews> data= stock_reviews_repo_object.findBoughtStockReviews(stock_ids);

        return data;
    }

    @GetMapping(path = "getPendingReviewsForUser/{user_id}/{bought_stock_ids}",produces = {"application/json"})
    @ResponseBody
    List<Integer> findPendingReviewsForUser(@PathVariable("user_id") int userid,
                                            @PathVariable("bought_stock_ids")List<Integer> stock_ids)
    {

        List<Integer> data= user_reviews_track_repo_object.findPendingReviewsByUser(stock_ids,userid);

        stock_ids.removeAll(data);

        return stock_ids;

    }

    @PostMapping(path="submitStockReview",consumes = {"application/json"})
    @ResponseBody
    stock_reviews submitStockReview(@RequestBody stock_reviews stock_reviews_object)
    {
        stock_reviews_repo_object.save(stock_reviews_object);
        return stock_reviews_object;
    }

    @PostMapping(path = "insertStockReviewTrackData",consumes = {"application/json"})
    @ResponseBody
    user_reviews_track insert_stock_review_data(@RequestBody user_reviews_track user_reviews_track_object)
    {
        user_reviews_track_repo_object.save(user_reviews_track_object);

        return user_reviews_track_object;
    }


    @GetMapping(path = "getAllForumQueries",produces = {"application/json"})
    @ResponseBody
    List<forum_main_db> getAllQueries()
    {
        List<forum_main_db> all_queries= forum_main_db_repo_object.findAll();

        return all_queries;
    }

    @GetMapping(path="searchForumByTag/{all_tags}",produces = {"application/json"})
    @ResponseBody
    List<forum_main_db> getSearchResultsForTags(@PathVariable("all_tags")List<String> all_tags_selected)
    {
        for(int i=0;i<all_tags_selected.size();i++)
        {
            all_tags_selected.set(i,"#"+all_tags_selected.get(i));
        }
        List<forum_main_db> search_result= forum_main_db_repo_object.searchByTags(all_tags_selected);

        return search_result;
    }

    @GetMapping(path="getAllPosts",produces = {"application/json"})
    @ResponseBody
    List<forum_main_db> getAllPosts()
    {
        List<forum_main_db> all_posts= forum_main_db_repo_object.findAll();

        return all_posts;
    }

    @GetMapping(path="getComments/{qstn_id}",produces = {"application/json"})
    @ResponseBody
    List<forum_answer_db> getCommentsByQstnId(@PathVariable("qstn_id") int qstn_id)
    {
        List<forum_answer_db> all_comments= forum_answer_db_repo_object.getCommentsByQuestionId(qstn_id);

        return all_comments;
    }

    @PostMapping(path = "postComment",consumes = {"application/json"})
    @ResponseBody
    forum_answer_db postForumComment(@RequestBody forum_answer_db answer_object)
    {
        forum_answer_db_repo_object.save(answer_object);

        return answer_object;
    }

    @PostMapping(path="postQuestion",consumes = {"application/json"})
    @ResponseBody
    forum_main_db postForumQuestion(@RequestBody forum_main_db question_object)
    {
        forum_main_db_repo_object.save(question_object);

        return question_object;
    }

    @PutMapping(path="updateQuestionStats/{qstn_id}",produces = {"application/json"})
    @ResponseBody
    forum_main_db updateStatsOfQuestion(@PathVariable("qstn_id") int question_id,@RequestBody forum_main_db obj)
    {
        return forum_main_db_repo_object.findById(question_id)
                .map(qstn_obj->{
                    qstn_obj.setTimes_answered(obj.getTimes_answered()+1);
                    qstn_obj.setForum_answr_status(0);
                    return forum_main_db_repo_object.save(qstn_obj);
                })
                .orElseGet(()->{
                    forum_main_db forum_obj= new forum_main_db(0,"",0,0,"",0,"");
                    return forum_main_db_repo_object.save(forum_obj);
                });
    }

    @GetMapping(path="getForumOverviewData/{user_id}",produces = {"application/json"})
    @ResponseBody
    forum_overview_dto forumOverviewData(@PathVariable("user_id") int user_id)
    {
        forum_overview_dto overview_data= new forum_overview_dto();

        try
        {
            overview_data.setNo_of_questions_posted(forum_main_db_repo_object.countQuestionsPosted(user_id));
            overview_data.setNo_of_questions_answered(forum_answer_db_repo_object.countAnswersPosted(user_id));
            overview_data.setAll_questions_posted(forum_main_db_repo_object.allQuestionsPosted(user_id));
            overview_data.setAll_answers_posted(forum_answer_db_repo_object.allAnswersPosted(user_id));

            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }




        return overview_data;
    }

    @GetMapping(path="getStockResearchData/{stock_id}",produces = {"application/json"})
    @ResponseBody
    stock_research_dto getResearchData(@PathVariable("stock_id") int stock_id)
    {
        stock_research_dto stock_research_object= new stock_research_dto();

        int total_investment= stock_sales_repo_object.findTotalInvestmentMade(stock_id);
        stock_research_object.setTotal_investment_made(total_investment);

        int total_returns= stock_sales_repo_object.findTotalReturnsMade(stock_id);
        stock_research_object.setTotal_returns_of_stock(total_returns);

        stock_research_object.setProfit_margin(total_returns-total_investment);

        stock_research_object.setNo_of_times_bought(stock_sales_repo_object.calculateNumberOfTimesStockBought(stock_id));

        stock_research_object.setNo_of_times_sold(stock_sales_repo_object.calculateNumberOfTimesStockSold(stock_id));


        stock_research_object.setAll_customers_ids(stock_sales_repo_object.all_customers_user_ids(stock_id));

        stock_research_object.setAll_reviews_available(stock_reviews_repo_object.findParticularStockReviews(stock_id));

        return stock_research_object;

    }

    List<Integer> compile_recommendations(List<Integer> stock_ids,List<Integer> main_list)
    {
        for(int x:stock_ids)
        {
            main_list.add(x);
        }

        return main_list;
    }

    @GetMapping(path="getStockRecommendations/{stock_id}",produces = "application/json")
    @ResponseBody
    List<stock_recommendations_dto> recommended_stocks(@PathVariable("stock_id") int stock_id)
    {
        List<Integer> all_customers_of_particular_stock= stock_sales_repo_object.all_customers_user_ids(stock_id);
        List<Integer> stock_id_to_remove= new ArrayList<>();
        stock_id_to_remove.add(stock_id);
        List<List<Integer>> all_bought_product_ids_of_users= new ArrayList<>();
        List<stock>recommended_stocks= new ArrayList<>();
        List<stock_recommendations_dto> result= new ArrayList<>();
        List<Integer>all_common_stocks_between_users= new ArrayList<>();

        for(int i=0;i<all_customers_of_particular_stock.size();i++)
        {
            List<Integer>stock_ids_bought= new ArrayList<>();
            stock_ids_bought=stock_sales_repo_object.findAllBoughtStocksIds(all_customers_of_particular_stock.get(i));
            //stock_ids_bought.removeAll(stock_id_to_remove);
            all_bought_product_ids_of_users.add(stock_ids_bought);
        }

        for(int i=0;i<all_bought_product_ids_of_users.size();i++)
        {
            all_common_stocks_between_users=compile_recommendations(all_bought_product_ids_of_users.get(i),all_common_stocks_between_users);
        }
        all_common_stocks_between_users.removeAll(stock_id_to_remove);
        HashSet<Integer>unique_ids= new HashSet<>(all_common_stocks_between_users);
            //stock data=stock_repo.findById(id).orElse(new stock(0,"",0,0,0,0));



        Iterator<Integer>iter=unique_ids.iterator();
        while(iter.hasNext())
        {
            int id= iter.next();
            int count=0;
            for(int id_num:all_common_stocks_between_users)
            {
                if(id==id_num)
                {
                    count+=1;
                }
            }
            stock data=stock_repo.findById(id).orElse(new stock(0,"",0,0,0,0));
            stock_recommendations_dto recommendations_dto_data= new stock_recommendations_dto();
            recommendations_dto_data.setStock_name(data.stock_name);
            recommendations_dto_data.setTimes_purchased(count);
            result.add(recommendations_dto_data);
        }

        return result;
    }




}
