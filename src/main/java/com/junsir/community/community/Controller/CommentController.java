package com.junsir.community.community.Controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {




    @RequestMapping("/putComment")
    public void  putComment(String comment){
        System.out.println(comment);
    }


}
