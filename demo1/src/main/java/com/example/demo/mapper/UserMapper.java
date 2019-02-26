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
    @Select("select id, `name`, age, `desc`, isdelete from user where id = #{id}")
    public User selectUserById(@Param("id") Long id);

    @Insert("insert into user(`name`, age, `desc`, isdelete) VALUES(#{name}, #{age}, #{desc}, #{isdelete})")
    public int insert(User user);

    @Update("update user set `name` =#{name}, age =#{age}, `desc` =#{desc}, isdelete =#{isdelete} where id = #{id}")
    public int update(User user);

    @Delete("delete from user where id = #{id}")
    public int delete(@Param("id") Long id);

    //注解删除多条数据用$ 并且用括号括起来，传的参数可以是字符串，""
    @Delete("delete from user where id in (${ids})")
    public int deletebyIds(@Param("ids") String ids);

    @Select("select id, `name`, age, `desc`, isdelete from user")
    public List<User> selectAllUser();
}
