package com.junsir.community.community.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.junsir.community.community.Dao.QuestionDao;
import com.junsir.community.community.Dto.QuestionDto;
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
}
