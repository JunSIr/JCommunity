package com.junsir.community.community.Provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junsir.community.community.model.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;


import java.io.IOException;
@Component
public class GitHubExchange {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();



        public  String post(String url, String json) throws IOException {
            RequestBody body = RequestBody.create(json, JSON);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }

        public  GitHubUser getUser(String token) throws IOException {

            /*Token切割*/
            String[] tokenStrArry = token.split("&");
            String tokenStr = tokenStrArry[0] ;
            tokenStrArry = tokenStr.split("=") ;
            tokenStr = tokenStrArry[1] ;

            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+tokenStr)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String resStr = response.body().string();

                GitHubUser user =  com.alibaba.fastjson.JSON.parseObject(resStr, GitHubUser.class);

                return user ;
            }
        }

        }



