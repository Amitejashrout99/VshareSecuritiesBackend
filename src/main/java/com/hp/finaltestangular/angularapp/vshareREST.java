package com.hp.finaltestangular.angularapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Component
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class vshareREST {
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

    @Autowired
    user_kyc_data_repo user_kyc_data_repo_object;

    @Autowired
    admin_credentials_repo admin_credentials_repo_object;

    @PostMapping(path = "verify_user", consumes = {"application/json"})
    @ResponseBody
    ResponseEntity<users> verify_user(@RequestBody users credentials_object) {

        users object = repo.findById(credentials_object.getUsername()).orElse(new users("", ""));
        if (object.getUsername().equals("")) {
            return new ResponseEntity<users>(object, HttpStatus.NOT_FOUND);
        } else if (!credentials_object.getPassword().equals(object.getPassword())) {
            return new ResponseEntity<users>(object, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<users>(object, HttpStatus.OK);
        }

    }

    @GetMapping(path = "getAllUsers", produces = {"application/json"})
    @ResponseBody
    List<user> get_all_user() {
        List<user> data = usrepo.findAll();
        return data;
    }

    @GetMapping(path = "checkAvailability/{user_name}", produces = {"application/json"})
    @ResponseBody
    boolean checkUsernameAvailability(@PathVariable("user_name") String username) {
        int status = usrepo.checkUsernameAvailabilityStatus(username);
        if (status == 1) {
            return false;
        } else {
            return true;
        }
    }

    @PostMapping(path = "add_user", consumes = "application/json")
    @ResponseBody
    user addNewUser(@RequestBody user new_user_object) {
        usrepo.save(new_user_object);

        return new_user_object;
    }

    @PostMapping(path = "add_user_credentials", consumes = "application/json")
    @ResponseBody
    users addNewUserCredentials(@RequestBody users new_user_credentials_object) {
        repo.save(new_user_credentials_object);

        return new_user_credentials_object;
    }

    @GetMapping(path = "getUserById/{uid}", produces = {"application/json"})
    @ResponseBody
    user get_user_by_id(@PathVariable("uid") int user_id) {
        user data = usrepo.findById(user_id).orElse(new user(0, " ", 0, " ", " ", " ", ""));
        return data;
    }

    @GetMapping(path = "checkAdminStatus/{user_name}", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<Integer> checkAdminStatus(@PathVariable("user_name") String username) {
        int status = admin_credentials_repo_object.checkAdminOrNot(username);

        if (status == 0) {
            return new ResponseEntity<Integer>(status, HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<Integer>(status, HttpStatus.OK);
        }

    }

    @PostMapping(path="createFBUserCredentials",consumes = {"application/json"})
    @ResponseBody
    ResponseEntity<users> createCredentialsForFBUser(@RequestBody users new_user)
    {
       repo.save(new_user);
       return new ResponseEntity<users>(new_user,HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "verifyAdminCredentials", consumes = {"application/json"})
    @ResponseBody
    ResponseEntity<admin_credentials> verifyCredentials(@RequestBody admin_credentials credentials) {
        admin_credentials obj = admin_credentials_repo_object.findById(credentials.admin_username).orElse(new admin_credentials("", ""));

        if (obj.admin_username.equals("")) {
            return new ResponseEntity<admin_credentials>(obj, HttpStatus.NOT_FOUND);
        } else if (!obj.admin_password.equals(credentials.admin_password)) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("password_status", "wrong");
            return new ResponseEntity<admin_credentials>(obj, headers, HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<admin_credentials>(obj, HttpStatus.OK);
        }

    }

    @GetMapping(path="verifyFacebookCredentials/{fb_id}",produces = {"application/json"})
    @ResponseBody
    ResponseEntity<users> checkFacebookCredentials(@PathVariable("fb_id") String facebook_id)
    {
        users obj=repo.findById(facebook_id).orElse(new users("",""));
        if(obj.getUsername().equals(""))
        {
            return new ResponseEntity<users>(obj,HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<users>(obj,HttpStatus.OK);
        }
    }

    @GetMapping(path = "allStocks", produces = {"application/json"})
    @ResponseBody
    List<stock> all_stocks_present() {
        List<stock> all_stocks = stock_repo.findAll();

        return all_stocks;
    }

    @GetMapping(path = "particularStock/{stock_id}", produces = {"application/json"})
    @ResponseBody
    stock get_particular_stock(@PathVariable("stock_id") int id_of_stock) {
        stock st = stock_repo.findById(id_of_stock).orElse(new stock(0, "", 0, 0, 0, 0));
        return st;
    }

    @GetMapping(path = "getUserId/{user_name}", produces = {"application/json"})
    @ResponseBody
    user get_particular_user_id(@PathVariable("user_name") String username) {
        user us = usrepo.find_id_of_user(username);
        return us;
    }

    @PostMapping(path = "addStockBuy", consumes = {"application/json"})
    @ResponseBody
    stock_sales add_stock_buy(@RequestBody stock_sales stock_buy_object) {

        System.out.print(stock_buy_object);
        stock_sales_repo_object.save(stock_buy_object);

        return stock_buy_object;
    }

    @PutMapping(path = "updateExistingStocks/{stockid}", produces = {"application/json"})
    @ResponseBody
    stock update_existing_stock(@PathVariable("stockid") int stock_id, @RequestBody stock_sales stock_buy_object) {
        return stock_repo.findById(stock_id)
                .map(stock_obj -> {
                    stock_obj.setStock_quantity(stock_obj.getStock_quantity() - stock_buy_object.no_of_times_bought);
                    return stock_repo.save(stock_obj);
                })
                .orElseGet(() -> {
                    stock st = new stock(0, "", 0, 0, 0, 0);
                    return stock_repo.save(st);
                });
    }

    @PostMapping(path = "addStockWatchlist", consumes = {"application/json"})
    @ResponseBody
    stock_watchlist add_stock_to_watchlist(@RequestBody stock_watchlist stock_watchlist_object) {
        stock_watchlist_repo_object.save(stock_watchlist_object);

        return stock_watchlist_object;
    }

    @GetMapping(path = "checkWatchListStatus/{stock_id}", produces = {"application/json"})
    @ResponseBody
    stock_watchlist check_waitlist_status(@PathVariable("stock_id") int stock_id) {
        stock_watchlist obj = stock_watchlist_repo_object.findWaitlistStatus(stock_id);

        return obj;
    }


    @DeleteMapping(path = "deleteWatchlistedStock/{watch_id}")
    @ResponseBody
    String deleteWatchlistedStock(@PathVariable("watch_id") int watchlist_id) {

        stock_watchlist_repo_object.deleteByWatchlistId(watchlist_id);

        return "Stock has been removed from watchlist";

    }

    @GetMapping(path = "allWatchlistedStocks", produces = {"application/json"})
    @ResponseBody
    List<stock_watchlist> all_watchlisted_stocks() {
        List<stock_watchlist> all_items = stock_watchlist_repo_object.findAll();

        return all_items;
    }

    @GetMapping(path = "getBoughtStocks/{uid}", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<List<stock_sales>> allBoughtStocks(@PathVariable("uid") int user_id) {
        List<stock_sales> boughtStockList = stock_sales_repo_object.findBoughtStocks(user_id);

        if(boughtStockList.size()==0)
        {
            return new ResponseEntity<>(boughtStockList,HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(boughtStockList,HttpStatus.OK);
        }
    }

    @PutMapping(path = "updateStockSaleData/{stock_sale_id}", produces = {"application/json"})
    @ResponseBody
    stock_sales update_stocksale_data(@PathVariable("stock_sale_id") int transaction_id, @RequestBody stock_sales stock_sell_object) {
        return stock_sales_repo_object.findById(transaction_id)
                .map(stock_sale_obj -> {
                    //stock_obj.setStock_quantity(stock_obj.getStock_quantity()-stock_buy_object.no_of_times_bought);
                    stock_sale_obj.setStock_sell_status("Yes");
                    stock_sale_obj.setNo_of_times_sold(stock_sell_object.getNo_of_times_sold());
                    stock_sale_obj.setStock_sold_on(stock_sell_object.getStock_sold_on());
                    stock_sale_obj.setPrice_sold_for(stock_sell_object.getPrice_sold_for());

                    return stock_sales_repo_object.save(stock_sale_obj);
                })
                .orElseGet(() -> {
                    stock_sales st = new stock_sales(0, " ", "", 0, 0, "", "", 0, 0, 0, 0);
                    return stock_sales_repo_object.save(st);
                });
    }

    @GetMapping(path = "getParticularStockSaleData/{stock_sale_id}", produces = {"application/json"})
    @ResponseBody
    stock_sales getParticularSellData(@PathVariable("stock_sale_id") int transaction_id) {
        stock_sales data = stock_sales_repo_object.findById(transaction_id).orElse(new stock_sales(0, " ", "", 0, 0, "", "", 0, 0, 0, 0));
        return data;
    }

    @GetMapping(path = "getAllBoughtStocks/{user_id}", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<List<stock_sales>> findAllBoughtStocks(@PathVariable("user_id") int userid) {
        List<stock_sales> all_bought_stocks = stock_sales_repo_object.findAllBoughtStocks(userid);

        if(all_bought_stocks.size()==0)
        {
            return new ResponseEntity<>(all_bought_stocks,HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(all_bought_stocks,HttpStatus.OK);
        }
    }

    @GetMapping(path = "getAllSoldStocks/{user_id}", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<List<stock_sales>> findAllSoldStocks(@PathVariable("user_id") int userid) {
        List<stock_sales> all_sold_stocks = stock_sales_repo_object.findAllSoldStocks(userid);

        if(all_sold_stocks.size()==0)
        {
            return new ResponseEntity<>(all_sold_stocks,HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(all_sold_stocks,HttpStatus.OK);
        }
    }

    @GetMapping(path = "BoughtStockReviews/{bought_stock_ids}", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<List<stock_reviews>> findBoughtStockReviews(@PathVariable("bought_stock_ids") List<Integer> stock_ids) {
        if (stock_ids.size() == 1 && stock_ids.get(0) == -1) {
            List<stock_reviews> temp = new ArrayList<>();
            temp.add(new stock_reviews(0, 0, "", 0, "", 0));
            return new ResponseEntity<List<stock_reviews>>(temp, HttpStatus.NOT_FOUND);
        } else {
            List<stock_reviews> data = stock_reviews_repo_object.findBoughtStockReviews(stock_ids);

            return new ResponseEntity<List<stock_reviews>>(data, HttpStatus.OK);
        }

    }

    @GetMapping(path = "getPendingReviewsForUser/{user_id}/{bought_stock_ids}", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<List<Integer>> findPendingReviewsForUser(@PathVariable("user_id") int userid,
                                                            @PathVariable("bought_stock_ids") List<Integer> stock_ids) {
        if (stock_ids.size() == 1 && stock_ids.get(0) == -1) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("No Item Found", "bad-request");
            return new ResponseEntity<List<Integer>>(stock_ids, HttpStatus.NOT_FOUND);
        } else {
            List<Integer> data = user_reviews_track_repo_object.findPendingReviewsByUser(stock_ids, userid);

            stock_ids.removeAll(data);

            return new ResponseEntity<List<Integer>>(stock_ids, HttpStatus.OK);
        }

        /*List<Integer> data= user_reviews_track_repo_object.findPendingReviewsByUser(stock_ids,userid);

        stock_ids.removeAll(data);

        return stock_ids;*/

    }

    @PostMapping(path = "submitStockReview", consumes = {"application/json"})
    @ResponseBody
    stock_reviews submitStockReview(@RequestBody stock_reviews stock_reviews_object) {
        stock_reviews_repo_object.save(stock_reviews_object);
        return stock_reviews_object;
    }

    @PostMapping(path = "insertStockReviewTrackData", consumes = {"application/json"})
    @ResponseBody
    user_reviews_track insert_stock_review_data(@RequestBody user_reviews_track user_reviews_track_object) {
        user_reviews_track_repo_object.save(user_reviews_track_object);

        return user_reviews_track_object;
    }


    @GetMapping(path = "getAllForumQueries", produces = {"application/json"})
    @ResponseBody
    List<forum_main_db> getAllQueries() {
        List<forum_main_db> all_queries = forum_main_db_repo_object.findAll();

        return all_queries;
    }

    @GetMapping(path = "searchForumByTag/{all_tags}", produces = {"application/json"})
    @ResponseBody
    List<forum_main_db> getSearchResultsForTags(@PathVariable("all_tags") List<String> all_tags_selected) {
        for (int i = 0; i < all_tags_selected.size(); i++) {
            all_tags_selected.set(i, "#" + all_tags_selected.get(i));
        }
        List<forum_main_db> search_result = forum_main_db_repo_object.searchByTags(all_tags_selected);

        return search_result;
    }

    @GetMapping(path = "getAllPosts", produces = {"application/json"})
    @ResponseBody
    List<forum_main_db> getAllPosts() {
        List<forum_main_db> all_posts = forum_main_db_repo_object.findAll();

        return all_posts;
    }

    @GetMapping(path = "getComments/{qstn_id}", produces = {"application/json"})
    @ResponseBody
    List<forum_answer_db> getCommentsByQstnId(@PathVariable("qstn_id") int qstn_id) {
        List<forum_answer_db> all_comments = forum_answer_db_repo_object.getCommentsByQuestionId(qstn_id);

        return all_comments;
    }

    @PostMapping(path = "postComment", consumes = {"application/json"})
    @ResponseBody
    forum_answer_db postForumComment(@RequestBody forum_answer_db answer_object) {
        forum_answer_db_repo_object.save(answer_object);

        return answer_object;
    }

    @PostMapping(path = "postQuestion", consumes = {"application/json"})
    @ResponseBody
    forum_main_db postForumQuestion(@RequestBody forum_main_db question_object) {
        forum_main_db_repo_object.save(question_object);

        return question_object;
    }

    @PutMapping(path = "updateQuestionStats/{qstn_id}", produces = {"application/json"})
    @ResponseBody
    forum_main_db updateStatsOfQuestion(@PathVariable("qstn_id") int question_id, @RequestBody forum_main_db obj) {
        return forum_main_db_repo_object.findById(question_id)
                .map(qstn_obj -> {
                    qstn_obj.setTimes_answered(obj.getTimes_answered() + 1);
                    qstn_obj.setForum_answr_status(0);
                    return forum_main_db_repo_object.save(qstn_obj);
                })
                .orElseGet(() -> {
                    forum_main_db forum_obj = new forum_main_db(0, "", 0, 0, "", 0, "");
                    return forum_main_db_repo_object.save(forum_obj);
                });
    }

    @GetMapping(path = "getForumOverviewData/{user_id}", produces = {"application/json"})
    @ResponseBody
    forum_overview_dto forumOverviewData(@PathVariable("user_id") int user_id) {
        forum_overview_dto overview_data = new forum_overview_dto();

        try {
            overview_data.setNo_of_questions_posted(forum_main_db_repo_object.countQuestionsPosted(user_id));
            overview_data.setNo_of_questions_answered(forum_answer_db_repo_object.countAnswersPosted(user_id));
            overview_data.setAll_questions_posted(forum_main_db_repo_object.allQuestionsPosted(user_id));
            overview_data.setAll_answers_posted(forum_answer_db_repo_object.allAnswersPosted(user_id));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return overview_data;
    }

    @GetMapping(path = "getStockResearchData/{stock_id}", produces = {"application/json"})
    @ResponseBody
    stock_research_dto getResearchData(@PathVariable("stock_id") int stock_id) {
        stock_research_dto stock_research_object = new stock_research_dto();

        int total_investment = stock_sales_repo_object.findTotalInvestmentMade(stock_id);
        stock_research_object.setTotal_investment_made(total_investment);

        int total_returns = stock_sales_repo_object.findTotalReturnsMade(stock_id);
        stock_research_object.setTotal_returns_of_stock(total_returns);

        stock_research_object.setProfit_margin(total_returns - total_investment);

        stock_research_object.setNo_of_times_bought(stock_sales_repo_object.calculateNumberOfTimesStockBought(stock_id));

        stock_research_object.setNo_of_times_sold(stock_sales_repo_object.calculateNumberOfTimesStockSold(stock_id));


        stock_research_object.setAll_customers_ids(stock_sales_repo_object.all_customers_user_ids(stock_id));

        stock_research_object.setAll_reviews_available(stock_reviews_repo_object.findParticularStockReviews(stock_id));

        return stock_research_object;

    }

    List<Integer> compile_recommendations(List<Integer> stock_ids, List<Integer> main_list) {
        for (int x : stock_ids) {
            main_list.add(x);
        }

        return main_list;
    }

    @GetMapping(path = "getStockRecommendations/{stock_id}", produces = {"application/json"})
    @ResponseBody
    List<stock_recommendations_dto> recommended_stocks(@PathVariable("stock_id") int stock_id) {
        List<Integer> all_customers_of_particular_stock = stock_sales_repo_object.all_customers_user_ids(stock_id);
        List<Integer> stock_id_to_remove = new ArrayList<>();
        stock_id_to_remove.add(stock_id);
        List<List<Integer>> all_bought_product_ids_of_users = new ArrayList<>();
        List<stock> recommended_stocks = new ArrayList<>();
        List<stock_recommendations_dto> result = new ArrayList<>();
        List<Integer> all_common_stocks_between_users = new ArrayList<>();

        for (int i = 0; i < all_customers_of_particular_stock.size(); i++) {
            List<Integer> stock_ids_bought = new ArrayList<>();
            stock_ids_bought = stock_sales_repo_object.findAllBoughtStocksIds(all_customers_of_particular_stock.get(i));
            //stock_ids_bought.removeAll(stock_id_to_remove);
            all_bought_product_ids_of_users.add(stock_ids_bought);
        }

        for (int i = 0; i < all_bought_product_ids_of_users.size(); i++) {
            all_common_stocks_between_users = compile_recommendations(all_bought_product_ids_of_users.get(i), all_common_stocks_between_users);
        }
        all_common_stocks_between_users.removeAll(stock_id_to_remove);
        HashSet<Integer> unique_ids = new HashSet<>(all_common_stocks_between_users);
        //stock data=stock_repo.findById(id).orElse(new stock(0,"",0,0,0,0));


        Iterator<Integer> iter = unique_ids.iterator();
        while (iter.hasNext()) {
            int id = iter.next();
            int count = 0;
            for (int id_num : all_common_stocks_between_users) {
                if (id == id_num) {
                    count += 1;
                }
            }
            stock data = stock_repo.findById(id).orElse(new stock(0, "", 0, 0, 0, 0));
            stock_recommendations_dto recommendations_dto_data = new stock_recommendations_dto();
            recommendations_dto_data.setStock_name(data.stock_name);
            recommendations_dto_data.setTimes_purchased(count);
            result.add(recommendations_dto_data);
        }

        return result;
    }


    @PutMapping(path = "updateKYCStatus/{user_id}", produces = {"application/json"})
    @ResponseBody
    user updateKYCStatus(@PathVariable("user_id") int uid, @RequestBody user obj) {
        return usrepo.findById(uid)
                .map(user_obj -> {
                    user_obj.setKyc_status("true");
                    return usrepo.save(user_obj);
                })
                .orElseGet(() -> {
                    user new_user = new user(0, "", 0, "", "", "", "");
                    return usrepo.save(new_user);
                });
    }

    @PostMapping(path = "postKYCData", consumes = {"application/json"})
    @ResponseBody
    user_kyc_data saveKYCData(@RequestBody user_kyc_data kyc_data_object) {
        user_kyc_data_repo_object.save(kyc_data_object);

        return kyc_data_object;
    }

    @GetMapping(path = "getKYCData/{user_id}", produces = {"application/json"})
    @ResponseBody
    user_kyc_data getKYCData(@PathVariable("user_id") int user_id) {
        user_kyc_data kyc_data_of_user = user_kyc_data_repo_object.findById(user_id)
                .orElse(new user_kyc_data(0, "", "", "", "", "", "", "", "", "", "", "", "", "", 0));

        return kyc_data_of_user;

    }

    @GetMapping(path = "getAllUsersData", produces = {"application/json"})
    @ResponseBody
    List<users_data_for_admin_dto> getAllUsersDataForAdmin() {
        List<users_data_for_admin_dto> all_data = new ArrayList<>();
        List<Integer> all_user_ids = new ArrayList<>();
        usrepo.findAll().forEach((user) -> all_user_ids.add(user.id));

        all_user_ids.forEach(id -> {

            users_data_for_admin_dto users_data_for_admin_dto_obj = new users_data_for_admin_dto();
            user obj = usrepo.findById(id).orElse(new user(0, "", 0, "", "", "", "false"));
            users_data_for_admin_dto_obj.setUser_name(obj.getName());
            users_data_for_admin_dto_obj.setUser_obj(obj);

            if (obj.getKyc_status().equals("true")) {
                user_kyc_data user_kyc_data_obj = user_kyc_data_repo_object.findById(obj.getId()).orElse(new user_kyc_data(0, "", "", "", "", "", "", "", "", "", "", "", "", "", 0));
                users_data_for_admin_dto_obj.setUser_kyc_data_obj(user_kyc_data_obj);
            }

            forum_overview_dto overview_data = new forum_overview_dto();

            overview_data.setNo_of_questions_posted(forum_main_db_repo_object.countQuestionsPosted(obj.id));
            overview_data.setNo_of_questions_answered(forum_answer_db_repo_object.countAnswersPosted(obj.id));
            overview_data.setAll_questions_posted(forum_main_db_repo_object.allQuestionsPosted(obj.id));
            overview_data.setAll_answers_posted(forum_answer_db_repo_object.allAnswersPosted(obj.id));


            users_data_for_admin_dto_obj.setForum_overview_dto_obj(overview_data);

            all_data.add(users_data_for_admin_dto_obj);

        });

        return all_data;

    }

    @GetMapping(path = "getAllTransactionData",produces = {"application/json"})
    @ResponseBody
    List<transactions_data_for_admin> getAllTransactionsDataForAdmin()
    {
        List<transactions_data_for_admin>all_data= new ArrayList<>();
        List<Integer> all_stock_id = new ArrayList<>();
        stock_repo.findAll().forEach((stock)-> all_stock_id.add(stock.getStock_id()));

        all_stock_id.forEach(stock_id-> {


            if (stock_sales_repo_object.checkStockBoughtOrNot(stock_id) == 1) {
                transactions_data_for_admin transactions_data_for_admin_obj = new transactions_data_for_admin();
                stock obj = stock_repo.findById(stock_id).orElse(new stock(0, "", 0, 0, 0, 0));

                transactions_data_for_admin_obj.setStock_name(obj.getStock_name());
                transactions_data_for_admin_obj.setStock_basic_data(obj);

                List<Integer> customers_who_bought_this_stock = new ArrayList<>();

                customers_who_bought_this_stock = stock_sales_repo_object.all_customers_user_ids(stock_id);

                List<user> customer_data = new ArrayList<>();
                List<user_kyc_data> customer_kyc_data = new ArrayList<>();

                customers_who_bought_this_stock.forEach(customer_id -> {

                    user user_obj = usrepo.findById(customer_id).orElse(new user(0, "", 0, "", "", "", "false"));
                    customer_data.add(user_obj);

                    if (user_obj.getKyc_status().equals("true")) {
                        user_kyc_data user_kyc_data_obj = user_kyc_data_repo_object.findById(customer_id).orElse(new user_kyc_data(0, "", "", "", "", "", "", "", "", "", "", "", "", "", 0));
                        customer_kyc_data.add(user_kyc_data_obj);
                    } else {
                        customer_kyc_data.add(new user_kyc_data(0, "", "", "", "", "", "", "", "", "", "", "", "", "", 0));
                    }

                });

                transactions_data_for_admin_obj.setCustomers_basic_data(customer_data);
                transactions_data_for_admin_obj.setCustomer_kyc_data(customer_kyc_data);
                transactions_data_for_admin_obj.setTotal_investment_made(stock_sales_repo_object.findTotalInvestmentMade(stock_id));
                transactions_data_for_admin_obj.setTotal_returns_made(stock_sales_repo_object.findTotalReturnsMade(stock_id));
                transactions_data_for_admin_obj.setStock_review_data(stock_reviews_repo_object.findParticularStockReviews(stock_id));

                transactions_data_for_admin_obj.setNo_of_times_bought(stock_sales_repo_object.calculateNumberOfTimesStockBought(stock_id));
                transactions_data_for_admin_obj.setNo_of_times_sold(stock_sales_repo_object.calculateNumberOfTimesStockSold(stock_id));

                all_data.add(transactions_data_for_admin_obj);

            }
            else
            {
                all_data.add(new transactions_data_for_admin());
            }


        });

        return all_data;

    }

}
