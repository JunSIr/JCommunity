package com.junsir.community.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junsir.community.community.Dto.PageDto;
import com.junsir.community.community.Dto.QuestionDto;

import java.util.List;

public interface PageService {

    public PageDto getPage(Integer currentPageNum) ;

    public PageDto getPageByUser(Integer currentPageNum,String userId) ;

}
