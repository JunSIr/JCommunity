package com.junsir.community.community.Controller;
import com.junsir.community.community.Dao.QuestionDao;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
    public class PublishController {

    @Autowired
    private QuestionDao questionDao;

    @GetMapping("/publish")
    public String toPublish() {

        return "publish";
    }

    @PostMapping("/publishQuesion")
    public String toPublishQuestion(Question question, HttpServletRequest request) {


        /*设置修改/发布时间*/
        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sim.format(date);
        question.setLastPushTime(dateStr);

        /*设置userID*/

            GitHubUser user = (GitHubUser) request.getSession().getAttribute("user");
            String id = user.getId();
            question.setUserId(id);
            questionDao.insertByFirstPush(question);






        return "redirect:/";
    }

    @RequestMapping("/toUpdateQuestion")
    public String  toUpdateQuestion(int id, Model model){
        System.out.println(id);
        model.addAttribute("id",id);

        Question question = questionDao.findQuestionById(id);
        model.addAttribute("question",question) ;

        return "updateQuestion" ;
    }
    @RequestMapping("/updateQuestion")
    public String  updateQuestion(Question question){
        /*设置修改/发布时间*/
        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sim.format(date);
        question.setLastPushTime(dateStr);

        questionDao.updateByPrimaryKeySelective(question) ;

        return "redirect:/profile" ;
    }
}

