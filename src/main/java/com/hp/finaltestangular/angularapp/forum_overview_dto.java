package com.hp.finaltestangular.angularapp;

import java.util.List;

public class forum_overview_dto
{
    int no_of_questions_posted;
    int no_of_questions_answered;
    List<forum_main_db> all_questions_posted;
    List<forum_answer_db>all_answers_posted;

    public forum_overview_dto()
    {

    }


    public forum_overview_dto(int no_of_questions_posted, int no_of_questions_answered, List<forum_main_db> all_questions_posted, List<forum_answer_db> all_answers_posted) {
        this.no_of_questions_posted = no_of_questions_posted;
        this.no_of_questions_answered = no_of_questions_answered;
        this.all_questions_posted = all_questions_posted;
        this.all_answers_posted = all_answers_posted;
    }

    public int getNo_of_questions_posted() {
        return no_of_questions_posted;
    }

    public void setNo_of_questions_posted(int no_of_questions_posted) {
        this.no_of_questions_posted = no_of_questions_posted;
    }

    public int getNo_of_questions_answered() {
        return no_of_questions_answered;
    }

    public void setNo_of_questions_answered(int no_of_questions_answered) {
        this.no_of_questions_answered = no_of_questions_answered;
    }

    public List<forum_main_db> getAll_questions_posted() {
        return all_questions_posted;
    }

    public void setAll_questions_posted(List<forum_main_db> all_questions_posted) {
        this.all_questions_posted = all_questions_posted;
    }

    public List<forum_answer_db> getAll_answers_posted() {
        return all_answers_posted;
    }

    public void setAll_answers_posted(List<forum_answer_db> all_answers_posted) {
        this.all_answers_posted = all_answers_posted;
    }
}
