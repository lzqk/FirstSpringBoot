package com.example.demo.controller;

import org.apache.commons.jexl3.*;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class UserTestControllerTest {


    @Test
    public void testRound(){
        System.out.println(2434.74+31*0.65*1.10);
        JexlEngine engine = new JexlBuilder().create();
        JexlExpression exp = engine.createExpression("-2434.74b+31*-0.65b*1.10b");
        JexlContext jc = new MapContext();
        System.out.println(exp.evaluate(jc));
//        System.out.println(31*0.65*1.1);
//        double b1=2434.74;
//        double b2 = 31*0.65*1.10;
//        System.out.println("b1:"+b1);
//        System.out.println("b2:"+b1);
//        System.out.println("b1+b2:"+(b1+b2));
//        BigDecimal a1 = new BigDecimal("2434.74").setScale(14,RoundingMode.HALF_UP);
//        BigDecimal a2 = new BigDecimal("31").multiply(new BigDecimal("0.65")).multiply(new BigDecimal("1.10")).setScale(14,RoundingMode.HALF_UP);
//        System.out.println(a1.add(a2));

    }

    @Test
    public void testJc(){
        //2434.74+31*0.65*1.10
        JexlEngine engine = new JexlBuilder().create();
        JexlExpression e = engine.createExpression("a+c*0.65*d");
        JexlExpression e2 = engine.createExpression("J12355+J32576*0.65b+J5439-0.85b+987");
        //100.12+1.1*0.65+31-0.85+987
        JexlContext jc = new MapContext();
        jc.set("J12355",new BigDecimal("100.12"));
//        Object o = 0.65;
//        if (o instanceof Double) {
//            jc.set("b", new BigDecimal(o.toString()));
//        }else{
//            jc.set("b",o);
//        }
        jc.set("J32576",new BigDecimal("1.1"));
        jc.set("J5439",new BigDecimal("31"));

        //System.out.println(e.evaluate(jc));
        System.out.println(e2.evaluate(jc));
    }

    @Test
    public void Zhengze(){

        /*String[] ps = param.split("[\\\\*]|[+]|[-]|[\\\\/]");
        for (String s:ps) {
            System.out.println(s);
        }
        String a = "0.65*b";
        String s = a.replaceAll("(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])","d");*/
        //J12355+J32576*0.65+J5439-0.85+987
        String param ="if(J12355>=58.25){return 1.2;}else if(J12355<=41.25){return 0.7;}else{return (1.2-0.7)*(J12355-41.25)/(58.25-41.25) +0.7;}";
        char ca[] = param.toCharArray();
        String pattern = "\\d+\\.\\d+";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(param);
        Set<String> set = new HashSet<>();
        while (m.find()) {
            param = param.replaceFirst(m.group(),m.group()+"b");
        }
        System.out.println(param);
        /*for (String s :set) {
            for(String t :set){
                if(s.contains(t)){

                }
            }

            param = param.replace(s,s+"b");
        }
        System.out.println(param);
        for (String s :set) {
            System.out.println(s);
        }*/

    }

    //private String replace()

    @Test
    public void StringEqul(){

        //if(10<2){return `区间函数`(`区间函数.单价`,`量化薪酬指标.工单办结量`);}else{return 9;}
        //String ss ="if(130.0 == 130){return 1; }else {return 2;}";
        String ss = "if(J12355=='一星'&&J12356=='否'){return 0.45b}else if(J12355=='一星'&&J12356=='是'){return 0.35b}else if(J12355=='二星'){return 0.5b}else if(J12355=='三星'){return 0.6b}else if(J12355=='四星'){return 0.7b}else if(J12355=='五星'){return 0.8b}";
        //String ss ="if('中国' == '中国'){return 1; }else {return 2;}";
        JexlEngine engine = new JexlBuilder().create();
        JexlExpression create = engine.createExpression(ss);
        JexlContext jc = new MapContext();
        jc.set("J12355","一星");
        jc.set("J12356","");
        Object o = create.evaluate(jc);
        System.out.println(o);

    }


    @Test
    public void testRegex(){
        BigDecimal b1 = new BigDecimal("22.22");
        BigInteger b2 = new BigInteger("22");
        Integer b3 = 11;
        Double b4 = 11.2d;
        Float b5 = 22.3457f;
        Long b6 = 676437437437L;
        Short b7 = 1;
        int i =1;
        if(b7 instanceof Number){
            System.out.println("true");
        } else {
            System.out.println("flase");
        }





        /*String param = "if(J12355>=58.25){return 1.2;}else if(J12355<=41.25){return 0.7;}else{return (1.2-0.7)*(J12355-41.25)/(58.25-41.25) +0.7;}";
//        String param = "58.25){return 1.2;}else if(J12355<=41.25){return 0.7;}else{return (1.2-0.7)*(J12355-41.25)/(58.25-41.25) +0.7;}";
//        String param = "58.25){return 1.2;}else if(J12355<=41.25){return 0.7;}else{return (1.2-0.7)*(J12355-41.25)/(58.25-41.25) +0.7";
        String pattern = "([^0-9]?)(\\d+\\.\\d+)([^0-9b]?)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(param);
        while (m.find()) {
            System.out.println(m.group(0)+"@@@"+m.group(1)+"@@@"+m.group(2)+"@@@"+m.group(3));
            param = param.replace(m.group(0),m.group(1)+m.group(2)+"b"+m.group(3));

        }
        System.out.println(param);*/


    }

    @Test
    public void testString(){
        String ss ="中1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        String aa = "5666666666666612d.00";
        System.out.println(aa.length());
        String uu =ss.length() >100 ?ss.substring(0,100) : ss;
        System.out.println(uu);
    }

    @Test
    public void testTre(){
        String ss ="中国 ss i ";
        String aa = ss.trim();
        System.out.println(aa);
        String uu =ss.length() >100 ?ss.substring(0,100) : ss;
        System.out.println(uu);
    }
    @Test
    public void testDate(){
        String ss ="202002";
        System.out.println(ss.substring(0,4).concat("年").concat(ss.substring(4,6).concat("月")));
        System.out.println(ss.substring(4,6).concat("月"));
    }
}