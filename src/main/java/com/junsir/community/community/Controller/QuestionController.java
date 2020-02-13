package com.junsir.community.community.Controller;

import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;
import com.junsir.community.community.service.QuestionService;
import com.junsir.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class QuestionController {


    @Autowired
    private QuestionService questionService ;

    @RequestMapping("/toQuestionDetail")
    public String  toQuestionDetail(int id, Model model){

        GitHubUser user = questionService.selectUserByQuestionId(id)  ;
        /*右侧问题发起的用户资料*/
        model.addAttribute("user",user)  ;

        /*更新浏览次数*/
        questionService.updateViewCounts(id);

        Question question = questionService.findQuestionById(id)  ;
        model.addAttribute("question",question)  ;



        return "questiondetail" ;
    }
}
