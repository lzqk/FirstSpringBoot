package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    /*String ss = "a+b-c*d/r";
    String s = "11+0.22+66*2.345*-0.65+J3455/0.85";*/

    public static void main(String[] args) {
        String str = "select * from order where createdUser = ${currentUser} and  depart = ${currentOrg} and status = 'VALID'";
        String reg = "\\$\\{[a-zA-Z0-9]+\\}";//定义正则表达式


        Pattern pat = Pattern.compile(reg);

        Matcher mat = pat.matcher(str);

        //boolean rs = mat.find();
        List<String> l = new ArrayList<>();
        while(mat.find()){
            l.add(mat.group());
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}
