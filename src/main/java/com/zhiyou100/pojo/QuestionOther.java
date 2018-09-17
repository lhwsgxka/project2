package com.zhiyou100.pojo;

import java.util.Date;

public class QuestionOther {
    private Integer questionotherid;

    private Integer questionid;

    private String questionothername;

    private Date questiondate;

    private String questionanswer;

    public Integer getQuestionotherid() {
        return questionotherid;
    }

    public void setQuestionotherid(Integer questionotherid) {
        this.questionotherid = questionotherid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestionothername() {
        return questionothername;
    }

    public void setQuestionothername(String questionothername) {
        this.questionothername = questionothername == null ? null : questionothername.trim();
    }

    public Date getQuestiondate() {
        return questiondate;
    }

    public void setQuestiondate(Date questiondate) {
        this.questiondate = questiondate;
    }

    public String getQuestionanswer() {
        return questionanswer;
    }

    public void setQuestionanswer(String questionanswer) {
        this.questionanswer = questionanswer == null ? null : questionanswer.trim();
    }
}