package com.junsir.community.community.Controller;

import com.alibaba.fastjson.JSONObject;
import com.junsir.community.community.Dao.GitHubUser;
import com.junsir.community.community.Provider.GitHubExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GitHubController {

    @Autowired
    public GitHubExchange gitHubExchange ;

    @GetMapping("/github/collback")
    public  String callback(@RequestParam(name = "code")String code) throws IOException {

        String url = "https://github.com/login/oauth/access_token" ;
        Map map = new HashMap() ;
        map.put("client_id","e8030320feea0161dd97");
        map.put("client_secret","0685dcad4a37616a90798fc3f93fedc3b5b646a7");
        map.put("code",code) ;
        JSONObject jsonObject = new JSONObject(map) ;
        String json = jsonObject.toString();
        String  accessToken = gitHubExchange.post(url,json) ;
        System.out.println(accessToken);

        GitHubUser user = gitHubExchange.getUser(accessToken) ;
        System.out.println(user);



        return  "index" ;
    }
}
