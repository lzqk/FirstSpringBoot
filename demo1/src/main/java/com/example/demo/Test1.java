package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        /*double[] v1 = new double[3];
        v1[0] = 1.0;
        v1[1] = 2.0;
        v1[2] = 3.0;
        System.out.println(v1.length);
        for(int i =0;i<v1.length; i++){
            System.out.println(v1[i]);
        }*/

        /*List<String> ss = new ArrayList<>();
        ss.add("a");
        ss.add("b");
        ss.add("c");
        ss.add("d");
        String[] strings = new String[ss.size()];

        ss.toArray(strings);
        for(String s : strings){
            System.out.println(s);
        }*/

        /*double[] v = new double[10];
        for(int i=0;i<10;i++){
            v[i] = Math.random()*10;
            System.out.print(v[i] + ",");
        }*/
        System.out.println("");
        double[] v = {10.0,76.0,12.0,45.0,14.0};
        Mean mean = new Mean();
        double ц = mean.evaluate(v);
        //System.out.println("ц:"+ String.format("%.2f", mean.evaluate(v)));
        System.out.println("ц:"+ц);

        StandardDeviation sd = new StandardDeviation();
        double σ = sd.evaluate(v);
        System.out.println("σ:"+ σ);
        //0.10278826788422096
        NormalDistribution nd = new NormalDistribution(0, 1);
        System.out.println("------分割线------");
        for(double d : v){
            double z=(d-ц)/σ;
            System.out.println(d+"的正态分布是"+nd.cumulativeProbability(z));
        }
        /*double d = 0.9095010750172692;
        BigDecimal b = BigDecimal.valueOf(d).multiply(new BigDecimal("100"));
        System.out.println(b);*/


        //double i= 49.6;
        //double z=(i-ц)/σ;
        //System.out.println(i+"的正态分布是"+nd.cumulativeProbability(z));
        //System.err.println(1-0.9999260988448327);
        //System.out.println(0.5+nd.probability(-3, 3)/2);
        /*List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(50);
        Map<Integer,Double> map = new HashMap();
        map.put(40,0.2);
        map.put(50,0.3);
        map.put(10,0.5);

        double d = 0.2 * 100;
        int[] meddleVal =new int[list.size()];
        for(int j=0;j<list.size();j++){
            if(j ==0){
                //第一个 比较100和当前值的大小
                if(d<=100 && d > (100-list.get(j).intValue())){
                    System.err.println(map.get(list.get(j)));
                }
                meddleVal[j] = 100-list.get(j).intValue();
            } else {
                if(d<=(meddleVal[j-1]) && d>(meddleVal[j-1]-list.get(j).intValue())){
                    System.err.println(map.get(list.get(j)));
                }
                meddleVal[j] = meddleVal[j-1]-list.get(j).intValue();
            }

        }*/

    }
}

