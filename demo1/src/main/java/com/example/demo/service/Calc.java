package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author: LK
 * @Description:
 * @Date: Create in 14:32 2020/6/13
 */
@Component
public class Calc {

    @Async
    public void add(int x,int y) throws Exception{
        Random random =new Random();
        System.out.println("insert add function");
        int s = x + y * x + y - x;
        Thread.sleep(random.nextInt(1000));
        System.out.println(s);
        System.out.println("function end");
    }
}
