package com.junsir.community.community.Dao;

import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionDao {

    public  int insertByFirstPush(Question question)  ;

    public List<QuestionDto> selectQuestionsAndUserAvatarToIndex()  ;
}
