package com.junsir.community.community.model;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class GitHubUser {
    private  String  login ;
    private  String id ;
    private String url  ;
    private String token ;
    private String avatarUrl  ;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Override
    public String toString() {
        return "GitHubUser{" +
                "login='" + login + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", token='" + token + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
