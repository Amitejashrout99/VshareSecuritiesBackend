package com.hp.finaltestangular.angularapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface forum_answer_db_repo extends JpaRepository<forum_answer_db,Integer>
{
    @Query("from forum_answer_db where question_id =:qstn_id")
    List<forum_answer_db> getCommentsByQuestionId(@Param("qstn_id")int question_id);


    @Query("select count(answer_id) from forum_answer_db where answer_user_id=:uid")
    int countAnswersPosted(@Param("uid") int user_id);


    @Query("from forum_answer_db where answer_user_id=:uid")
    List<forum_answer_db> allAnswersPosted(@Param("uid") int user_id);
}
