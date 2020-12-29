package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.bean.User;
import com.example.demo.common.ReturnBean;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Api("测试User")
public class UserTestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "testuser" ,method = RequestMethod.GET)
    @ApiOperation(value = "测试hello User",notes="测试notes作用")
    public String test(){
        return "hello User！";
    }

    @RequestMapping(value = "/getUserNoSQL",method = RequestMethod.GET)
    @ApiOperation(value = "获取User信息")
    public User getUser(){
        User user = new User();
        user.setAge(22);
        user.setName("lk");
        System.out.println("test1-->2");
        return user;
    }

    //查询一条
    @RequestMapping(value = "/getOneUser",method = RequestMethod.GET)
    @ApiOperation(value = "获取一条数据库User信息")
    public User selectUserById(@RequestParam("id") Long id){
        System.out.println("User is comeing");
        return userService.selectUserById(id);
    }

    //新增一条
    @RequestMapping(value ="insertUser",method = RequestMethod.POST)
    @ApiOperation(value = "新增一条数据")
    public ReturnBean insertUser(@RequestBody User user){
        ReturnBean returnBean = new ReturnBean();
        /*User user = new User();
        user.setAge(20);
        user.setName("wtl");
        user.setDesc("123");*/
        int count = userService.insert(user);
        if(count > 0){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("新增成功");
        }else{
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("新增失败");
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
        int count = userService.update(user);
        if(count > 0){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("更新成功");
        }else{
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("更新失败");
        }
        return returnBean;
    }

    //删除一条
    @RequestMapping(value ="deleteUser",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除一条数据")
    public ReturnBean deleteUser(@RequestParam("id") Long id){
        ReturnBean returnBean = new ReturnBean();
        int count = userService.delete(id);
        if(count > 0){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("删除成功");
        }else{
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("删除失败");
        }
        return returnBean;
    }

    //删除多条
    @RequestMapping(value ="deleteUsers",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除多条数据")
    public ReturnBean deleteUsers(@RequestParam("ids") String ids){
        ReturnBean returnBean = new ReturnBean();
        int count = userService.deletebyIds(ids);
        if(count > 0){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("删除多条数据成功");
        }else{
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("删除多条数据失败");
        }
        return returnBean;
    }

    //分页查询
    @RequestMapping(value = "/pageUser",method = RequestMethod.GET)
    @ApiOperation(value = "分页获取User信息")
    public Object pageUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                   int pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                   int pageSize){
        System.out.println("User is comeing" + pageNum);
        return userService.findAllUser(pageNum,pageSize);
    }

}
