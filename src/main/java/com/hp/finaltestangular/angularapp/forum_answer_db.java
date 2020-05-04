package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class forum_answer_db
{
    @Id
    int answer_id;
    String forum_answer;
    int answer_user_id;
    String answr_given_on;
    int question_id;

    public forum_answer_db()
    {

    }

    public forum_answer_db(int answer_id, String forum_answer, int answer_user_id, String answr_given_on, int question_id) {
        this.answer_id = answer_id;
        this.forum_answer = forum_answer;
        this.answer_user_id = answer_user_id;
        this.answr_given_on = answr_given_on;
        this.question_id = question_id;
    }


    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getForum_answer() {
        return forum_answer;
    }

    public void setForum_answer(String forum_answer) {
        this.forum_answer = forum_answer;
    }

    public int getAnswer_user_id() {
        return answer_user_id;
    }

    public void setAnswer_user_id(int answer_user_id) {
        this.answer_user_id = answer_user_id;
    }

    public String getAnswr_given_on() {
        return answr_given_on;
    }

    public void setAnswr_given_on(String answr_given_on) {
        this.answr_given_on = answr_given_on;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
}
