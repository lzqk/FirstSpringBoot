package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.bean.UserExample;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User selectByPrimaryKey(Long id);

    public int deleteByPrimaryKey(Long id);

    public int insert(User record);

    public int updateByPrimaryKey(User record);

    public PageInfo<User> findAllUser(int pageNum, int pageSize, User userExample);

    public List<User> queryByMap(Map map);

    int updateTest(User record);

    int batchInsert(List list);

    int testCount(String tableName, String filed, String value);

    int testSum(String sumFiled,String tableName, String filed, String value);

}
