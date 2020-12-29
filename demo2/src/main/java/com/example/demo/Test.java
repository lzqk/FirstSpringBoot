package com.example.demo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: LK
 * @Description:
 * @Date: Create in 17:34 2020/4/1
 */
public class Test {
    /*public static void main(String[] args) {
        Map<Integer, String> ma = new HashMap<Integer, String>();
        //给集合中存入元素
        ma.put(1, "abc01");    //这里将基本数据类型自动装箱
        ma.put(2, "abc02");
        ma.put(3, "abc03");
        ma.put(4, "abc04");
        //将Map集合当中的映射关系取出，存入到Set集合当中
        Set<Map.Entry<Integer, String>> entryset = ma.entrySet();
        //取迭代器
        Iterator<Map.Entry<Integer, String>> it = entryset.iterator();
        //获取Map集合中的元素
        while (it.hasNext()) {
            Map.Entry<Integer, String> en = it.next();
            Integer maKey = en.getKey();
            String maValue = en.getValue();
            System.out.println(maKey + " : " + maValue);
        }
    }*/

    /*public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(11);
        l1.add(12);
        l1.add(13);
        l1.add(14);
        l1.add(15);
        List<Integer> l2 = new ArrayList<>();
        l2.add(21);
        l2.add(22);
        l2.add(23);
        l2.add(24);
        l2.add(25);
        list.add(l1);
        list.add(l2);

        for(List<Integer> l : list){
            //System.out.println(i);
            for(Integer i : l){
                if(i==12){
                    System.out.println(i);
                    //break;//跳出当前循环 继续执行循环后面的语句。
                    continue;//跳过当前循环 继续执行下次循环
                }
                i++;
                System.out.println(i);
            }
        }
    }*/


    /*public static void main(String[] args) {
        //int a = 0;
        for(int i=0;i<10;i++){
            System.out.println("i:"+i);

            if(i==2){
                continue;
            }
            System.out.println("j:"+i);
        }
        *//*int i=0;
        while (true){
            i++;
            int start = (i-1) * 5000 +1;
            int end = i*5000;
            System.out.println("start:"+start+" end:"+end);
            System.out.println(i);
            if(i == 3){
                break;
            }
        }*//*

        //String ss = "202009";
        //System.out.println(ss.substring(0,ss.length() - 2));
    }*/

    /*public static void main(String[] args) {
        String ss = ".222";
        if(ss.startsWith(".")){
            System.out.println("0"+ss);
        }
        //System.out.println(ss);

    }*/
    public static void main(String[] args) {
        Map<String,String> m = new HashMap<>();
        m.put("aa","sss");
        if(m.get("aa").length() >0){
            System.out.println("true");
        }
        if(m.get("bb").length() >0){
            System.out.println("ff");
        }
    }

}
