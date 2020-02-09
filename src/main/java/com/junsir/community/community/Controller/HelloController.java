package com.junsir.community.community.Controller;



import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @Autowired
    private UserService userService ;

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("name", name);





        Cookie[] cookies =  request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie1 : cookies) {
                if ("token".equals(cookie1.getName())){
                    String token = cookie1.getValue() ;
                    System.out.println("tokenStr="+token);
                    GitHubUser user = userService.selectUserByToken(token);
                    if (user!=null){
                        /*user写入session*/
                        request.getSession().setAttribute("user",user);
                        break;
                    }


                }
            }
        }

        /*将Token通过Cookie存到用户客户端（浏览器）
         * */
        String tokenStr = request.getParameter("token");

        if (tokenStr!=null) {
            /*加入Cookie*/
            Cookie cookie = new Cookie("token", tokenStr);
            response.addCookie(cookie);
        }
        return "index";
    }

}