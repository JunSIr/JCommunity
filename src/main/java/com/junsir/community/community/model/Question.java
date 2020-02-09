package com.junsir.community.community.model;

import java.io.Serializable;
import java.util.Date;

/**
 * question
 * @author 
 */
public class Question implements Serializable {
    private Integer id;

    private String title;

    private Integer commentCount;

    private Integer viewCount;

    private Integer awesomeCount;

    private String tag;

    private String userId;

    private Date lastPushTime;

    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAwesomeCount() {
        return awesomeCount;
    }

    public void setAwesomeCount(Integer awesomeCount) {
        this.awesomeCount = awesomeCount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastPushTime() {
        return lastPushTime;
    }

    public Date setLastPushTime(Date lastPushTime) {
        this.lastPushTime = lastPushTime;
        return lastPushTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", commentCount=" + commentCount +
                ", viewCount=" + viewCount +
                ", awesomeCount=" + awesomeCount +
                ", tag='" + tag + '\'' +
                ", userId='" + userId + '\'' +
                ", lastPushTime=" + lastPushTime +
                ", description='" + description + '\'' +
                '}';
    }
}