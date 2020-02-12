package com.junsir.community.community.Controller;

import com.alibaba.fastjson.JSONObject;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.Provider.GitHubExchange;

import com.junsir.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GitHubController {

    @Autowired
    public GitHubExchange gitHubExchange ;

    @Autowired
    private UserService userService ;

    /*快速提取配置文件的内容*/
    @Value("${client_id}")
    public String clientId ;

    @Value("${client_secret}")
    public  String clientSecret ;

    @GetMapping("/github/collback")
    public  String callback(@RequestParam(name = "code")String code, HttpServletRequest request,  RedirectAttributes attributes) throws IOException {

        /*遵从GitHub第三方登陆授权流程*/
        String url = "https://github.com/login/oauth/access_token" ;
        Map map = new HashMap() ;
        map.put("client_id",clientId);
        map.put("client_secret",clientSecret);
        map.put("code",code) ;
        JSONObject jsonObject = new JSONObject(map) ;
        String json = jsonObject.toString();
        String  accessToken = gitHubExchange.post(url,json) ;



        /*得到Github用户信息并以对象存储*/
        GitHubUser user = gitHubExchange.getUser(accessToken) ;
        System.out.println(user);

        /*新用户入库*/
        if (userService.selectUserById(user.getId())==null){
            userService.insertUserInToMysql(user) ;
        }

        /*将token传到即将转发的Controller*/
        GitHubUser user1= userService.selectUserById(user.getId());
        String token = user1.getToken();
        attributes.addAttribute("token",token);




        /*user写入session*/
        request.getSession().setAttribute("user",user);





        /*Controller之间的重定向
        * 在本人博客Spring-MVC中末尾
        * */
        return  "redirect:/" ;
    }
}
