package com.junsir.community.community.service;

import com.junsir.community.community.model.GitHubUser;

public interface UserService {

    public GitHubUser selectUserById(String id) ;

    public GitHubUser selectUserByToken(String token) ;

    public int insertUserInToMysql(GitHubUser user);



}
