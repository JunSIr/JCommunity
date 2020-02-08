package com.junsir.community.community.service.serviceimpl;

import com.junsir.community.community.mapper.UserMapper;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper ;

    @Override
    public GitHubUser selectUserById(String id) {
         GitHubUser user = userMapper.findByID(id);
         System.out.println(user);
        return user ;
    }

    @Override
    public int insertUserInToMysql(GitHubUser user) {

        int k = userMapper.insertInToMySql(user) ;
        System.out.println(k);
        return k;
    }
}
