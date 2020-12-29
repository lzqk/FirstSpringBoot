package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formula {
    private String cnName;//中文名称
    private String enName;//英文名称
    public String type;//1,数据源,2,自定义函数,3,公共函数
    public String source;//数据来源，1,量化薪酬指标,2,员工信息,3,单价

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String threeYearsAgo =sdf.format(new Date());
        System.out.println(Integer.valueOf(threeYearsAgo) -1);
    }

}
