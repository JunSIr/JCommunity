package com.junsir.community.community.Controller;

import com.junsir.community.community.Dto.PageDto;
import com.junsir.community.community.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    @Autowired
    private PageService pageService ;
    @RequestMapping("/profile")
    public String toProfile(){
        return  "profile" ;
    }

    @RequestMapping("/profile/question")
    public String toProfileQuestion(Integer currentPageNum,Model model){
        PageDto pageDto =  pageService.getPage(currentPageNum) ;
        /*写给前端页面*/
        model.addAttribute("pageDto",pageDto)  ;

        /*给thymeleaf with JS准备的*/
        model.addAttribute("pageNum",pageDto.getPageNum());
        model.addAttribute("pages",pageDto.getPages());
        model.addAttribute("listQ",pageDto.getQuestionList());
        model.addAttribute("question","question");
        return  "profile" ;
    }

    @RequestMapping("/profile/recommendation")
    public String toProfileRecommendation(Model model){
        model.addAttribute("recommendation","recommendation");
        return  "profile" ;
    }

    @RequestMapping("/profile/comment")
    public String toProfileComment(Model model){
        model.addAttribute("comment","comment");
        return  "profile" ;
    }
}
