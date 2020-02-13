package com.junsir.community.community.service;

import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;

import java.util.List;

public interface QuestionService {

    public List<QuestionDto> selectQuestionsAndUserAvatarToIndex();


    public GitHubUser selectUserByQuestionId(int id) ;

    public   Question findQuestionById(int id )  ;

    public  int updateByPrimaryKeySelective(Question question)  ;

    public void  updateViewCounts(int id) ;

}
