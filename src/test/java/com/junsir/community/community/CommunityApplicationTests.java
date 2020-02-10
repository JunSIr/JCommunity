package com.junsir.community.community;

import com.junsir.community.community.Dao.QuestionDao;

import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.mapper.UserMapper;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private UserMapper userMapper ;



    @Autowired
    private QuestionDao questionDao ;
    @Test
    void contextLoads() {
    }

    @Test
    void testSelect(){

        List<QuestionDto> listQ  = questionDao.selectQuestionsAndUserAvatarToIndex() ;
        for (QuestionDto questionDto : listQ) {
            System.out.println(questionDto);
        }

    }

}
