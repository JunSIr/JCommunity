package com.junsir.community.community.model;

import org.hibernate.validator.constraints.EAN;

import java.io.Serializable;
import java.util.List;

/**
 * comment
 * @author 
 */
public class Comment implements Serializable {
    private Integer commentId;

    private String userId;

    private Integer questionId;

    private String commentInfo;

    private GitHubUser user ;

    public GitHubUser getUser() {
        return user;
    }

    public void setUser(GitHubUser user) {
        this.user = user;
    }

    private static final long serialVersionUID = 1L;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }



}