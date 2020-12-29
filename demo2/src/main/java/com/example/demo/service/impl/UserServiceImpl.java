package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.bean.UserExample;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record){
        return userMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize, User userExample) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userMapper.selectByExample(userExample);
        PageInfo<User> result = new PageInfo<User>(userDomains);
        return result;
    }

    @Override
    public List<User> queryByMap(Map map) {
        return userMapper.queryByMap(map);
    }

    @Override
    public int updateTest(User record){
        return userMapper.updateTest(record);
    }

    @Override
    public int batchInsert(List list) {
        return userMapper.batchInsert(list);
    }

    @Override
    public int testCount(String tableName, String filed, String value) {
        return userMapper.testCount(tableName,filed,value);
    }

    @Override
    public int testSum(String sumFiled,String tableName, String filed, String value) {
        return userMapper.testSum(sumFiled,tableName,filed,value);
    }

}
