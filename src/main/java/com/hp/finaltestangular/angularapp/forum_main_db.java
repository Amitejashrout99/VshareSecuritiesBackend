package com.hp.finaltestangular.angularapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class forum_main_db
{
    @Id
    int qstn_id;
    String forum_qstn;
    int forum_answr_status;
    int qstn_user_id;
    String qstn_askd_on;
    int times_answered;
    String qstn_tag;

    public forum_main_db()
    {

    }

    public forum_main_db(int qstn_id,
            String forum_qstn,
            int forum_answr_status,
            int qstn_user_id,
            String qstn_askd_on,
            int times_answered,
            String qstn_tag)
    {
        this.qstn_id=qstn_id;
        this.forum_qstn=forum_qstn;
        this.forum_answr_status=forum_answr_status;
        this.qstn_user_id=qstn_user_id;
        this.qstn_askd_on=qstn_askd_on;
        this.times_answered = times_answered;
        this.qstn_tag=qstn_tag;
    }



    public int getQstn_id() {
        return qstn_id;
    }

    public void setQstn_id(int qstn_id) {
        this.qstn_id = qstn_id;
    }

    public String getForum_qstn() {
        return forum_qstn;
    }

    public void setForum_qstn(String forum_qstn) {
        this.forum_qstn = forum_qstn;
    }

    public int getForum_answr_status() {
        return forum_answr_status;
    }

    public void setForum_answr_status(int forum_answr_status) {
        this.forum_answr_status = forum_answr_status;
    }

    public int getQstn_user_id() {
        return qstn_user_id;
    }

    public void setQstn_user_id(int qstn_user_id) {
        this.qstn_user_id = qstn_user_id;
    }

    public String getQstn_askd_on() {
        return qstn_askd_on;
    }

    public void setQstn_askd_on(String qstn_askd_on) {
        this.qstn_askd_on = qstn_askd_on;
    }

    public int getTimes_answered() {
        return times_answered;
    }

    public void setTimes_answered(int times_answered) {
        this.times_answered = times_answered;
    }

    public String getQstn_tag() {
        return qstn_tag;
    }

    public void setQstn_tag(String qstn_tag) {
        this.qstn_tag = qstn_tag;
    }
}
