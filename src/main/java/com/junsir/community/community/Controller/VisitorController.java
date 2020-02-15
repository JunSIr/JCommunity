package com.junsir.community.community.Controller;

import com.junsir.community.community.mapper.UserMapper;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class VisitorController {
    @Autowired
    private UserMapper userMapper ;

    @Autowired
    private UserService userService ;


    @RequestMapping("/toRegisteVisitor")
    public  String toVisitorRegister(){

        return "VisitorRegister" ;
    }

    @RequestMapping("/registeVisitor")
    public  String visitorRegister(String userName , HttpServletRequest request, HttpServletResponse response ,Model model){
        /*判断用户名是否重复*/
        GitHubUser user1 = userService.selectUserById(userName) ;
        /*用户名已存在或userName为空*/
        if (user1!=null||userName==null){
            model.addAttribute("tip","tip") ;
            return "VisitorRegister" ;
        }else if(userName!=null) {
            /*随意处理的，后期有机会再重构*/
            GitHubUser user = new GitHubUser();
            user.setLogin(userName);
            user.setToken(userName);
            user.setUrl(userName);

            user.setAvatarUrl("https://pic.qqtn.com/up/2019-9/15688885645564375.jpg");
            user.setId(userName);

            /*session与cookie*/

                /*加入Cookie*/
                Cookie cookie = new Cookie("token", userName);
                response.addCookie(cookie);

            userMapper.insertInToMySql(user);
            request.getSession().setAttribute("user", user);
        }
        return "redirect:/" ;
    }
}
