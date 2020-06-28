package com.example.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: LK
 * @Description:
 * @Date: Create in 17:34 2020/4/1
 */
public class DocTest {

    /*public static void main(String[] args) {
        String ss = "1234-5678-22";
        String s1 = ss.substring(s1.indexOf("-") +1);

    }*/

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("cc");
        list.forEach(s -> System.err.println(s));
        List<String> l1 = list.stream().distinct().collect(Collectors.toList());
        //l1.forEach(s -> System.out.println(s));
        List<String> l2 = l1.stream().filter(s -> !"aa".equals(s)).collect(Collectors.toList());
        l2.forEach(s -> System.out.println(s));
        StringBuilder sb = new StringBuilder();
        for(String s : l2) {
            sb.append(s).append(";");
        }
        System.out.println(sb.toString());
    }




}
