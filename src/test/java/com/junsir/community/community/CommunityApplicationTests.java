package com.junsir.community.community;

import com.junsir.community.community.mapper.UserMapper;
import com.junsir.community.community.model.GitHubUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private UserMapper userMapper ;

    @Test
    void contextLoads() {
    }

    @Test
    void testSelect(){

/*        GitHubUser user = userMapper.findByID("56471335");
        System.out.println(user);*/
        GitHubUser user =new GitHubUser();
        user.setId("111");
        user.setLogin("junsir");
        user.setUrl("www.alibaba.com");

        int k = userMapper.insertInToMySql(user) ;
        System.out.println(k);
    }

}
