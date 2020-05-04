package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface forum_main_db_repo extends JpaRepository<forum_main_db,Integer>
{
    @Query("from forum_main_db where qstn_tag in :tags")
    List<forum_main_db> searchByTags(@Param("tags") List<String>all_tags);

    @Query("select count(qstn_id) from forum_main_db where qstn_user_id=:uid")
    int countQuestionsPosted(@Param("uid") int user_id);

    @Query("from forum_main_db where qstn_user_id=:uid")
    List<forum_main_db> allQuestionsPosted(@Param("uid") int user_id);
}
