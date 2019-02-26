package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUserById(Long id){
        return userMapper.selectUserById(id);
    }

    public int insert(User user){
        return userMapper.insert(user);
    }

    public int update(User user){
        return userMapper.update(user);
    }

    public int delete(Long id){
        return userMapper.delete(id);
    }

    public int deletebyIds(String ids){
        return userMapper.deletebyIds(ids);
    }
    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userMapper.selectAllUser();
        PageInfo<User> result = new PageInfo<User>(userDomains);
        return result;
    }
}
