package com.junsir.community.community.mapper;

import com.junsir.community.community.model.GitHubUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM GITHUB_USER WHERE ID = #{id}")
    @Results({
            @Result( property = "login",column = "user_name")
            }) GitHubUser findByID(@Param("id") String id);



    @Select("SELECT * FROM GITHUB_USER WHERE token = #{token}")
    @Results({
            @Result( property = "login",column = "user_name")
    }) GitHubUser findByToken(@Param("token") String token);


    /*注解Param内的参数与数据库表对应
    * userName则无关
    * */
   /* @Insert("insert into GITHUB_USER (user_name, id, url) values (#{user_name},#{id},#{url})")
    int insertInToMySql(@Param("id") String id,@Param("user_name") String userName,@Param("url") String url);*/


/*错误示范
* 在value后面不应该有user
* 原因：与批量插入操作混淆
* 如配置情况下：collection="personList" separator="," item="person" ->此种情况下应该使用person.形式
* */
/*    @Insert("insert into GITHUB_USER (user_name, id, url) values (#{user.login},#{user.id},#{user.url})")
    @Results({
            @Result( property = "login",column = "user_name")
    })
    int insertInToMySql(GitHubUser user);*/

    @Insert("insert into GITHUB_USER (user_name, id, url,token) values (#{login},#{id},#{url},#{token})")
    @Results({
            @Result( property = "login",column = "user_name")
    })
    int insertInToMySql(GitHubUser user);

}
