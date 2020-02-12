package com.junsir.community.community.Dto;

import com.junsir.community.community.model.Question;

import java.util.List;

public class PageDto {
    /*当前页码*/
    private  Integer pageNum ;
    /*总页数*/
    private  Integer pages ;
    /*问题*/
    private List<QuestionDto> questionList ;

    public List<QuestionDto> getQuestionList() {
        return questionList;
    }


    public void setQuestionList(List<QuestionDto> questionList) {
        this.questionList = questionList;
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
