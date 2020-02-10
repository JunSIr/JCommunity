package com.junsir.community.community.Dto;

import java.util.List;

public class QuestionDto {
    private Integer id;
    private String title;
    private Integer commentCount;
    private Integer viewCount;
    private Integer awesomeCount;
    private String tag;
    private String userId;
    private String lastPushTime;
    private String description;
    /*新增属性*/
    private String avatarUrl ;

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

    public String getLastPushTime() {
        return lastPushTime;
    }

    public void setLastPushTime(String lastPushTime) {
        this.lastPushTime = lastPushTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", commentCount=" + commentCount +
                ", viewCount=" + viewCount +
                ", awesomeCount=" + awesomeCount +
                ", tag='" + tag + '\'' +
                ", userId='" + userId + '\'' +
                ", lastPushTime='" + lastPushTime + '\'' +
                ", description='" + description + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
