package com.junsir.community.community.Dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageRowBounds;
import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface QuestionDao {

    public  int insertByFirstPush(Question question)  ;



    public List<QuestionDto> selectQuestionsAndUserAvatarToIndex()  ;
    /*个人问题*/
    public List<QuestionDto> selectQuestionsAndUserAvatarToIndexByUser(String UserId)  ;

    public GitHubUser selectUserByQuestionId(int id) ;

    public   Question findQuestionById(int id )  ;

    public  int updateByPrimaryKeySelective(Question question)  ;

    public void  updateViewCounts(int id) ;
}
