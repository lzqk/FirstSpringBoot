package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.Calc;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LK
 * @Description:
 * @Date: Create in 15:01 2020/6/13
 */
@RestController
@RequestMapping(value = "/async")
@Api("测试异步调用")
public class AsyncTest {
    @Autowired
    private Calc calc;
    //查询一条
    @RequestMapping(value = "/async",method = RequestMethod.GET)
    @ApiOperation(value = "测试异步调用")
    public String selectUserById() throws Exception{
        System.err.println("Start 方法");
        calc.add(100,2000);
        System.err.println("success");
        return "success";
    }
}
