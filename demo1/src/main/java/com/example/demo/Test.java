package com.example.demo;

import org.apache.commons.math3.fitting.GaussianCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

import java.math.BigDecimal;
import java.util.*;

public class Test {

    //public static void main(String[] args) {
    //Map<String,String> m1= new HashMap<>();
        /*//*Map<String,Map<String,String>> m1 = new HashMap<>();
        Map<String,String> m11= new HashMap<>();
        m11.put("a1","A1");
        m11.put("a2","A2");
        m1.put("a",m11);
        //Map<String,Map<String,String>> m2 = new HashMap<>();
        Map<String,String> m12= new HashMap<>();
        m12.put("a1","A1");
        m12.put("a2","B2");
        m1.put("b",m12);
        //Map<String,Map<String,String>> m3 = new HashMap<>();
        Map<String,String> m13= new HashMap<>();
        m13.put("a1","C1");
        m13.put("a2","C2");
        m1.put("c",m13);
        //m1.put("aa",JSONObject.toJSONString(m2));
        //String ss = m1.get("aa");
        //System.err.println(ss);
        //Map<String,Map<String,String>> ms = JSONObject.parseObject(ss,Map.class);
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Map<String,String>> entry :m1.entrySet()){
            //System.out.println(entry.getKey());
            for(Map.Entry<String,String> ent : entry.getValue().entrySet()){
                if(ent.getKey().equals("a1")){
                    list.add(ent.getValue());
                }
                //System.out.println("key:"+ent.getKey()+";val:" +ent.getValue());
            }
        }

        for(String s : list){
            System.err.println(s);
        }*/

    //List<Map<String,Integer>> list = new ArrayList<>();
        /*Map<String, BigDecimal> map = new HashMap<>();
        map.put("1",new BigDecimal(1));
        map.put("2",new BigDecimal(2));
        map.put("3",new BigDecimal(3));
        List<Map.Entry<String,BigDecimal>> list = new ArrayList<Map.Entry<String,BigDecimal>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String, BigDecimal>>(){
            //降序排序
            public int compare(Map.Entry<String,BigDecimal> o1, Map.Entry<String ,BigDecimal> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<String, BigDecimal> mapping:list) {
            System.out.println(mapping.getKey());
            if(mapping.getKey().equals("3")){
                System.err.println(list.indexOf(mapping)+1);
            }
        }*/

    //}
    /*public static void main(String[] args) {

        //数据准备
        String empId = "1001";
        String salOrgId = "2001";
        //<empId salOrgId>
        Map<String,String> m1 = new HashMap<>();
        m1.put("1001","2001");
        m1.put("1002","2001");
        m1.put("1003","2001");
        m1.put("1004","2002");
        m1.put("1005","2002");
        //empId <projId,val>
        Map<String,Map<String, String>> m2 = new HashMap<>();
        m2.put("1001",new HashMap<String,String>(){
            {
                put("001","11");
                put("002","43");
                put("003","65");
                put("004","23");
            }
        });
        m2.put("1002",new HashMap<String,String>(){
            {
                put("001","23");
                put("002","67");
                put("003","89");
                put("004","100");
            }
        });
        m2.put("1003",new HashMap<String,String>(){
            {
                put("001","23");
                put("002","78");
                put("003","93");
                put("004","78");
            }
        });
        m2.put("1004",new HashMap<String,String>(){
            {
                put("001","56");
                put("002","87");
                put("003","77");
                put("004","79");
            }
        });
        m2.put("1005",new HashMap<String,String>(){
            {
                put("001","95");
                put("002","88");
                put("003","83");
                put("004","79");
            }
        });

        //循环人员 获取人员对应的所有的指标的值
        List<String> list = new ArrayList<>();
        Map<String, BigDecimal> empValue = new HashMap<>();
        for(Map.Entry<String,Map<String,String>> entry :m2.entrySet()){
            //System.out.println(entry.getKey());
            if(m1.get(entry.getKey()).equals(salOrgId)){
                //查询当前序列下所有人的数据
                for(Map.Entry<String,String> ent : entry.getValue().entrySet()){
                    if(ent.getKey().equals("001")){
                        list.add(ent.getValue());
                        empValue.put(entry.getKey(),new BigDecimal(ent.getValue()));
                    }
                    //System.out.println("key:"+ent.getKey()+";val:" +ent.getValue());
                }
            }

        }

        for(String s : list){
            System.out.println(s);//11,23,23
        }


        List<Map.Entry<String,BigDecimal>> l1 = new ArrayList<Map.Entry<String,BigDecimal>>(empValue.entrySet());
        Collections.sort(l1,new Comparator<Map.Entry<String, BigDecimal>>(){
            //降序排序
            public int compare(Map.Entry<String,BigDecimal> o1, Map.Entry<String ,BigDecimal> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<String, BigDecimal> mapping:l1) {
            System.out.println(mapping.getKey());
            if(mapping.getKey().equals(empId)){
                System.err.println(l1.indexOf(mapping)+1);
            }
        }

    }*/
    /*public static void main(String[] args) {
        WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(0, 1);
        obs.add(1, 2);
        obs.add(2, 3);
        obs.add(3, 4);
        obs.add(4, 5);
        obs.add(5, 4);
        obs.add(6, 3);
        obs.add(7, 2);
        obs.add(8, 1);

        double[] parameters = GaussianCurveFitter.create().fit(obs.toList());
        for (double i : parameters) {
            System.out.println(i);
        }
    }*/

    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("10");
        BigDecimal i = new BigDecimal("3");
        BigDecimal t = b.divide(i,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(t);
    }
}
