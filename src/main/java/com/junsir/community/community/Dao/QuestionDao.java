package com.junsir.community.community.Dao;

import com.junsir.community.community.model.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionDao {

    public  int insertByFirstPush(Question question)  ;

    public  Question findQuestionById(Integer id )  ;
}
