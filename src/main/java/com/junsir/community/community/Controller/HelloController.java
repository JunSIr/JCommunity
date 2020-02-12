package com.junsir.community.community.Controller;



import com.junsir.community.community.Dto.PageDto;
import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;
import com.junsir.community.community.service.PageService;
import com.junsir.community.community.service.QuestionService;
import com.junsir.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HelloController {



    @Autowired
    private QuestionService questionService ;

    @Autowired
    private PageService pageService ;

    @GetMapping("/")
    public String greeting(Model model, HttpServletRequest request, HttpServletResponse response) {

        /*将Token通过Cookie存到用户客户端（浏览器）
         * */
        String tokenStr = request.getParameter("token");
        if (tokenStr!=null) {
            /*加入Cookie*/
            Cookie cookie = new Cookie("token", tokenStr);
            response.addCookie(cookie);
        }

        /*
        * 主页展示问题列表
        * */

        /*获取问题集合*/
        List<QuestionDto> listQ = questionService.selectQuestionsAndUserAvatarToIndex();
        model.addAttribute("listQ",listQ) ;

        /*初始化页面参数*/
        PageDto pageDto =  pageService.getPage(0) ;
        model.addAttribute("pageDto",pageDto)  ;

        return "index";
    }

}