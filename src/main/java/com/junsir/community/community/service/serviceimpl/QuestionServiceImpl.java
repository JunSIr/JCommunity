package com.junsir.community.community.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.junsir.community.community.Dao.QuestionDao;
import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;
import com.junsir.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override

    public List<QuestionDto> selectQuestionsAndUserAvatarToIndex() {

        PageHelper.startPage(1, 5);
        List<QuestionDto> listQ  = questionDao.selectQuestionsAndUserAvatarToIndex() ;

        return listQ;
    }

    @Override
    public GitHubUser selectUserByQuestionId(int id) {
        GitHubUser user = questionDao.selectUserByQuestionId(id) ;
        return user ;
    }

    @Override
    public Question findQuestionById(int id) {
        Question question = questionDao.findQuestionById(id) ;
        return  question ;
    }

    @Override
    public int updateByPrimaryKeySelective(Question question) {
        int k = questionDao.updateByPrimaryKeySelective(question) ;
        return  k ;
    }
}
