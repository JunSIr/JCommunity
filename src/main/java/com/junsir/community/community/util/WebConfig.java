package com.junsir.community.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private Interceptor interceptor ;

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor).addPathPatterns("/**");

    }
}
