package com.example.demo.service;

import com.github.pagehelper.PageInfo;
import com.example.demo.bean.User;
public interface UserService {

    public User selectByPrimaryKey(Long id);

    public int deleteByPrimaryKey(Long id);

    public int insert(User record);

    public int updateByPrimaryKey(User record);

    public PageInfo<User> findAllUser(int pageNum, int pageSize);
}
