package com.example.demo.controller;

import com.example.demo.aop.MyAnnotation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class AspectTestController {
    @MyAnnotation
    @RequestMapping("/add1")
    public String addData1(String deviceId) {
        return "success";
    }

    @RequestMapping("/add2")
    public String addData2(String deviceId) {
        return "success";
    }
    @RequestMapping("/add3")
    public String addData3(String deviceId) {
        return "success";
    }
}
