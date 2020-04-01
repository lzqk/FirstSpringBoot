package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.bean.UserExample;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User selectByPrimaryKey(Long id);

    public int deleteByPrimaryKey(Long id);

    public int insert(User record);

    public int updateByPrimaryKey(User record);

    public PageInfo<User> findAllUser(int pageNum, int pageSize, UserExample userExample);

    public List<User> queryByMap(Map map);
}
