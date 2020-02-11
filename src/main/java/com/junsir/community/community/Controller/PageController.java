package com.junsir.community.community.Controller;

import com.junsir.community.community.Dto.PageDto;
import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;
import com.junsir.community.community.service.PageService;
import com.junsir.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private PageService pageService ;

    @Autowired
    private QuestionService questionService ;


    @RequestMapping("/Page")
    public String Page(Integer currentPageNum, Model model) {


        /*获取问题集合*/

/*        List<QuestionDto> listQ = questionService.selectQuestionsAndUserAvatarToIndex();
        model.addAttribute("listQ",listQ) ;*/

        PageDto pageDto =  pageService.getPage(currentPageNum) ;
        /*写给前端页面*/
        model.addAttribute("pageDto",pageDto)  ;

        /*给thymeleaf with JS准备的*/
        model.addAttribute("pageNum",pageDto.getPageNum());
        model.addAttribute("pages",pageDto.getPages());
        model.addAttribute("listQ",pageDto.getQuestionList());

        return  "index" ;
    }

}
