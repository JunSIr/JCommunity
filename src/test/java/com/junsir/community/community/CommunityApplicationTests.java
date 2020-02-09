package com.junsir.community.community;

import com.junsir.community.community.Dao.QuestionDao;
import com.junsir.community.community.Dao.UserDao;
import com.junsir.community.community.mapper.UserMapper;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private UserMapper userMapper ;

    @Autowired
    private UserDao userDao ;

    @Autowired
    private QuestionDao questionDao ;
    @Test
    void contextLoads() {
    }

    @Test
    void testSelect(){

        Integer id = 1 ;
        Question question = questionDao.findQuestionById(id) ;
        System.out.println(question);


    }

}
