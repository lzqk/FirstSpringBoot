package com.example.demo3.service;

import com.example.demo3.bean.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

    public User selectByPrimaryKey(Long id);

    public int deleteByPrimaryKey(Long id);

    public int insert(User record);

    public int updateByPrimaryKey(User record);

    public PageInfo<User> findAllUser(int pageNum, int pageSize);
}