package com.example.demo.schedule;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyStaticTask {


    //注解配置定时任务
    @Autowired
    private UserService userService;

    /*@Scheduled(cron = "0/10 * * * * ?")
    public void doTask(){
        System.out.println("执行了MyStaticTask,时间为:"+new Date(System.currentTimeMillis()));
    }

    @Scheduled(cron = "* 0/1 * * * ?")
    public void doInsertTask(){
        User user = new User();
        user.setuAge(25);
        user.setuName("lk");
        user.setuDesc("ss");
        userService.insert(user);
        System.out.println("doInsertTask,时间为:"+new Date(System.currentTimeMillis()));
    }*/

}
