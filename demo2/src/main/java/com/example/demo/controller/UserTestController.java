package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import com.example.demo.bean.UserExample;
import com.example.demo.common.ReturnBean;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
@Api("测试User")
public class UserTestController {

    private final static Logger logger = LoggerFactory.getLogger(UserTestController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "testuser" ,method = RequestMethod.GET)
    @ApiOperation(value = "测试hello User",notes="测试notes作用")
    public String test(){
        return "hello User！";
    }


    @RequestMapping(value = "/getOneUser",method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取User")
    public User selectUserById(@RequestParam("id") Long id){
        logger.info("User is comeing" + id);
        User user = userService.selectByPrimaryKey(id);
        logger.info(user.toString());
        return user;
    }

    @RequestMapping(value = "/pageUser",method = RequestMethod.GET)
    @ApiOperation(value = "分页获取User信息")
    public Object pageUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                       int pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                       int pageSize){
        UserExample userExample = null;
        logger.info("This is Page" + pageNum);
        return userService.findAllUser(pageNum,pageSize,userExample);
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加User")
    public ReturnBean addUser(@RequestBody User user){
        ReturnBean returnBean = new ReturnBean();
        logger.info("User"+ JSONObject.toJSONString(user));
        if(userService.insert(user) > 0 ){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("添加成功");
            logger.info("添加成功");
        }else {
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("添加失败");
            logger.info("添加失败");
        }
        return returnBean;
    }


    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除User")
    public ReturnBean deleteUser(@RequestParam("id") Long id){
        ReturnBean returnBean = new ReturnBean();
        logger.info("User is delete");
        if(userService.deleteByPrimaryKey(id) > 0 ){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("删除成功");
            logger.info("删除成功");
        }else {
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("删除失败");
            logger.info("删除失败");
        }
        return returnBean;
    }

    //更新一条
    @RequestMapping(value ="updateUser",method = RequestMethod.PUT)
    @ApiOperation(value = "更新一条数据")
    public ReturnBean updateUser(@RequestBody User user){
        ReturnBean returnBean = new ReturnBean();
        logger.info("User is update"+ JSONObject.toJSONString(user));
        int count = userService.updateByPrimaryKey(user);
        if(count > 0){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("更新成功");
            logger.info("更新成功");
        }else{
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("更新失败");
            logger.info("更新失败");
        }
        return returnBean;
    }

    @RequestMapping(value = "/testSearchMap",method = RequestMethod.GET)
    @ApiOperation(value = "实验Mybatis的paramterMap的用法")
    public User testSearchMap(){
        logger.info("testSearchMap");
        Map map = new HashMap();
        map.put("name","张三");
        List<User> user = userService.queryByMap(map);
        logger.info(user.get(0).toString());
        return user.get(0);
    }


}
