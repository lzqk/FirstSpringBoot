package com.example.demo.mapper;


import com.example.demo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * spring boot 整合mybatis 的方法一 注解的方式
 * 如果不想每个Mapper上都加@Mapper注解可以在DemoApplication.java上加上
 * @MapperScan("com.example.demo.mapper")
 * 来扫描mapper路径
 *
 */
//@Mapper
public interface UserMapper {
    @Select("select u_id, u_name, u_age, u_desc from t_user where u_id = #{id}")
    public User selectUserById(@Param("id") Long id);

    @Insert("insert into t_user(u_name, u_age, u_desc) VALUES(#{u_name}, #{u_age}, #{u_desc})")
    public int insert(User user);

    @Update("update t_user set u_name =#{u_name}, u_age =#{u_age}, u_desc =#{u_desc} where u_id = #{u_id}")
    public int update(User user);

    @Delete("delete from t_user where u_id = #{id}")
    public int delete(@Param("id") Long id);

    @Select("select u_id, u_name, u_age, u_desc from t_user")
    public List<User> selectAllUser();
}
