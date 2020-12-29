package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import com.example.demo.bean.UserExample;
import com.example.demo.common.ReturnBean;
import com.example.demo.service.UserService;
import com.example.demo.util.BeanUtil;
import com.example.demo.util.DBUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
@Api("测试User")
public class UserTestController {

    private final static Logger logger = LoggerFactory.getLogger(UserTestController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DBUtil dbUtil;

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
        User userExample = new User();
        userExample.setName("1");
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
        map.put("test","1");
        List<User> user = userService.queryByMap(map);
        logger.info(user.get(0).toString());
        return user.get(0);
    }

    //更新一条
    @RequestMapping(value ="updateTest",method = RequestMethod.PUT)
    @ApiOperation(value = "更新一条数据")
    public ReturnBean updateTest(@RequestBody User user){
        ReturnBean returnBean = new ReturnBean();
        logger.info("User is update"+ JSONObject.toJSONString(user));
        int count = userService.updateTest(user);
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

    @RequestMapping(value = "/testDBUtil",method = RequestMethod.GET)
    @ApiOperation(value = "实验可配置sql功能")
    public ReturnBean testDBUtil(){
        ReturnBean returnBean = new ReturnBean();
        logger.info("testDBUtil");
        Map map = new HashMap();
        map.put("oper","<=");
        map.put("val","15");

        List<String> idList= new ArrayList<>();
        idList.add("1");
        idList.add("2");
        idList.add("3");
        String ids = StringUtils.join(idList.toArray(), ",");
        logger.info(ids);
        String tableSql = "select * from user where age "+map.get("oper") + map.get("val") + " and id in(" + ids + ")";

        logger.info(tableSql);
        List<Map<String,Object>> result = dbUtil.execute(tableSql);

        returnBean.setReturnCode("1");
        returnBean.setReturnMessage("查询成功");
        returnBean.getBean().put("total",String.valueOf(result.size()));
        returnBean.setExt2(result);
        return returnBean;
    }

    @RequestMapping(value = "/testbatchInsert",method = RequestMethod.GET)
    @ApiOperation(value = "测试批量新增")
    public ReturnBean testbatchInsert(){
        ReturnBean returnBean = new ReturnBean();
        logger.info("testbatchInsert");
        Map m1 = new HashMap();
        m1.put("i_d","1");
        m1.put("na_me","aa");
        m1.put("a_ge",21);
        m1.put("de_sc","aaaaa");
        m1.put("is_delete","0");
        Map m2 = new HashMap();
        m2.put("i_d","2");
        m2.put("na_me","bb");
        m2.put("a_ge",null);
        m2.put("de_sc","bbbbbb");
        m2.put("is_delete","0");
        Map m3 = new HashMap();
        m3.put("i_d","3");
        m3.put("na_me","cc");
        m3.put("a_ge",24);
        m3.put("de_sc","ccccc");
        m3.put("is_delete","0");
        Map m4 = new HashMap();
        m4.put("i_d","4");
        m4.put("na_me","dd");
        m4.put("de_sc","dddd");
        m4.put("is_delete","0");
        List list = new ArrayList();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        int count = userService.batchInsert(list);
        if(count > 0){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("批量新增成功");
            logger.info("批量新增成功");
        }else{
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("批量新增失败");
            logger.info("批量新增失败");
        }
        return returnBean;
    }



    @RequestMapping(value = "/testQuery",method = RequestMethod.GET)
    @ApiOperation(value = "分页获取User信息")
    public Object testQuery(){

        //return userService.testCount("user","name","aa");
        return userService.testSum("age","user","name","u1");
    }
}
