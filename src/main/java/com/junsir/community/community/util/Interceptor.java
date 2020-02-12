package com.junsir.community.community.util;

import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService ;



    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        /*检测用户浏览器是否存在当前用户*/
        Cookie[] cookies =  request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie1 : cookies) {
                if ("token".equals(cookie1.getName())){
                    String token = cookie1.getValue() ;
                    System.out.println("tokenStr="+token);
                    GitHubUser user = userService.selectUserByToken(token) ;

                    if (user!=null){
                        /*user写入session*/
                        request.getSession().setAttribute("user",user);
                        break;
                    }
                }
            }
        }

        /*放行*/
        return true;
    }

}
