package com.junsir.community.community.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junsir.community.community.Dao.QuestionDao;
import com.junsir.community.community.Dto.PageDto;
import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private QuestionDao questionDao ;


    @Override
    public PageDto getPage(Integer currentPageNum) {

        PageHelper.startPage(currentPageNum+1, 8);
        List<QuestionDto> listQ  = questionDao.selectQuestionsAndUserAvatarToIndex() ;

        PageInfo pageInfo= new PageInfo(listQ);
        /*取当前页码*/
        Integer pageNum = pageInfo.getPageNum();
        /*取总页数*/
        Integer pages = pageInfo.getPages();

        PageDto pageDto  =new PageDto() ;
        pageDto.setPageNum(pageNum);
        pageDto.setPages(pages);
        pageDto.setQuestionList(listQ);

        return pageDto;

    }

    @Override
    public PageDto getPageByUser(Integer currentPageNum,String userId) {
        PageHelper.startPage(currentPageNum+1, 5);
        List<QuestionDto> listQ = questionDao.selectQuestionsAndUserAvatarToIndexByUser(userId);

        PageInfo pageInfo = new PageInfo(listQ);
        /*取当前页码*/
        Integer pageNum = pageInfo.getPageNum();
        /*取总页数*/
        Integer pages = pageInfo.getPages();

        PageDto pageDto = new PageDto();
        pageDto.setPageNum(pageNum);
        pageDto.setPages(pages);
        pageDto.setQuestionList(listQ);
        return pageDto;

    }


}
