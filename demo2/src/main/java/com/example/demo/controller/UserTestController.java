package com.example.demo.controller;

import com.example.demo.common.ReturnBean;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.bean.User;

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

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ApiOperation(value = "获取User信息")
    public User getUser(){
        User user = new User();
        user.setuAge(22);
        user.setuName("lk");
        user.setuDesc("ss");
        logger.info("test1-->2");
        System.out.println("test1-->2");
        return user;
    }

    @RequestMapping(value = "/getOneUser",method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取User")
    public User selectUserById(@RequestParam("id") Long id){
        System.out.println("User is comeing" + id);
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
        logger.info("User is comeing" + pageNum);
        System.out.println("User is comeing" + pageNum);
        return userService.findAllUser(pageNum,pageSize);
    }

    @RequestMapping(value = "/deletteUser",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除User")
    public ReturnBean deletteUser(@RequestParam("id") Long id){
        ReturnBean returnBean = new ReturnBean();
        System.out.println("User is add");
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

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加User")
    public ReturnBean addUser(@RequestBody User user){
        ReturnBean returnBean = new ReturnBean();
        System.out.println("User is add");
        //User user = new User();
        //user.setuAge(22);
        //user.setuName("张三");
        //user.setuDesc("desc");
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

    //更新一条
    @RequestMapping(value ="updateUser",method = RequestMethod.PUT)
    @ApiOperation(value = "更新一条数据")
    public ReturnBean updateUser(@RequestBody User user){
        ReturnBean returnBean = new ReturnBean();
        /*User user = new User();
        user.setId(2);
        user.setAge(25);
        user.setName("wxk");
        user.setDesc("321");*/
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

}
