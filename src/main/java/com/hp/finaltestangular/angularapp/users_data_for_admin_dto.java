package com.hp.finaltestangular.angularapp;

public class users_data_for_admin_dto
{
    String user_name;
    user user_obj;
    user_kyc_data user_kyc_data_obj;
    forum_overview_dto forum_overview_dto_obj;

    public users_data_for_admin_dto()
    {

    }

    public user getUser_obj() {
        return user_obj;
    }

    public void setUser_obj(user user_obj) {
        this.user_obj = user_obj;
    }

    public users_data_for_admin_dto(String user_name, user user_obj, user_kyc_data user_kyc_data_obj, forum_overview_dto forum_overview_dto_obj) {
        this.user_name = user_name;
        this.user_obj = user_obj;
        this.user_kyc_data_obj = user_kyc_data_obj;
        this.forum_overview_dto_obj = forum_overview_dto_obj;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public user_kyc_data getUser_kyc_data_obj() {
        return user_kyc_data_obj;
    }

    public void setUser_kyc_data_obj(user_kyc_data user_kyc_data_obj) {
        this.user_kyc_data_obj = user_kyc_data_obj;
    }

    public forum_overview_dto getForum_overview_dto_obj() {
        return forum_overview_dto_obj;
    }

    public void setForum_overview_dto_obj(forum_overview_dto forum_overview_dto_obj) {
        this.forum_overview_dto_obj = forum_overview_dto_obj;
    }
}
