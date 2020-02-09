package com.junsir.community.community.Dao;

import com.junsir.community.community.model.GitHubUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户信息
     */
    GitHubUser  findUserById(String id);

}