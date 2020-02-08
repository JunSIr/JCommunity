package com.junsir.community.community.Controller;

import com.alibaba.fastjson.JSONObject;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.Provider.GitHubExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GitHubController {

    @Autowired
    public GitHubExchange gitHubExchange ;

    /*快速提取配置文件的内容*/
    @Value("${client_id}")
    public String clientId ;

    @Value("${client_secret}")
    public  String clientSecret ;

    @GetMapping("/github/collback")
    public  String callback(@RequestParam(name = "code")String code, HttpServletRequest request) throws IOException {

        /*遵从GitHub第三方登陆授权流程*/
        String url = "https://github.com/login/oauth/access_token" ;
        Map map = new HashMap() ;
        map.put("client_id",clientId);
        map.put("client_secret",clientSecret);
        map.put("code",code) ;
        JSONObject jsonObject = new JSONObject(map) ;
        String json = jsonObject.toString();
        String  accessToken = gitHubExchange.post(url,json) ;


        GitHubUser user = gitHubExchange.getUser(accessToken) ;

        System.out.println(user);

        /*user写入session*/
        request.getSession().setAttribute("user",user);


        /*Controller之间的重定向
        * 在本人博客Spring-MVC中末尾
        * */
        return  "redirect:/" ;
    }
}
