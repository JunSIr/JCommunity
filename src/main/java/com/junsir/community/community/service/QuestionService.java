package com.junsir.community.community.service;

import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.Question;

import java.util.List;

public interface QuestionService {

    public List<QuestionDto> selectQuestionsAndUserAvatarToIndex();

}
