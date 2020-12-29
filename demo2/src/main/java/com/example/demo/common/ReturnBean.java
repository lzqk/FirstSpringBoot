package com.example.demo.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnBean {
    private String returnCode;// 返回编码
    private String returnMessage;// 返回消息
    private String timeStamp;//时间戳防止加密内容一致
    private Map<String, String> bean;
    private List<Map<String, String>> beans;
    private Map<String, Object> ext1;
    private List<Map<String, Object>> ext2;


    public ReturnBean() {
        this.bean=new HashMap<String, String>();
        this.returnMessage="sucess";
        this.timeStamp=String.valueOf(System.currentTimeMillis());
        this.returnCode="0";
        this.beans=new ArrayList<Map<String, String>>();
        this.ext2=new ArrayList<>();
    }

    public ReturnBean(String returnCode, String returnMessage) {
        this.bean=new HashMap<String, String>();
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.timeStamp=String.valueOf(System.currentTimeMillis());
        this.beans=new ArrayList<Map<String, String>>();
    }


    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    public String getReturnMessage() {
        return returnMessage;
    }
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public Map<String, String> getBean() {
        return bean;
    }

    public void setBean(Map<String, String> bean) {
        this.bean = bean;
    }

    public List<Map<String, String>> getBeans() {
        return beans;
    }

    public void setBeans(List<Map<String, String>> beans) {
        this.beans = beans;
    }

    public Map<String, Object> getExt1() {
        return ext1;
    }

    public void setExt1(Map<String, Object> ext1) {
        this.ext1 = ext1;
    }

    public List<Map<String, Object>> getExt2() {
        return ext2;
    }

    public void setExt2(List<Map<String, Object>> ext2) {
        this.ext2 = ext2;
    }
}
