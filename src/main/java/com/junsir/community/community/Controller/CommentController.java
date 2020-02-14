package com.junsir.community.community.Controller;

import com.junsir.community.community.model.Comment;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.service.CommentService;
import com.junsir.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class CommentController {


    @Autowired
    private CommentService commentService ;

    @Autowired
    private QuestionService questionService ;

    @Transactional
    @RequestMapping("/putComment")
    public void  putComment(String commentInfo, Integer userId, HttpServletRequest request){

        Comment comment  = new Comment() ;
        comment.setCommentInfo(commentInfo);
        comment.setQuestionId(userId);
        /*从session中拿取回复的用户*/
        GitHubUser user = (GitHubUser) request.getSession().getAttribute("user");
        String userId1 = user.getId();
        comment.setUserId(userId1);

        commentService.insert(comment);
        questionService.updateCommentCount(userId);


    }
}
