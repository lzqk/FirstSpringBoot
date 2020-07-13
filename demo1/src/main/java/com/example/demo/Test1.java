package com.example.demo;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        double[] v = {1.0, 2.0, 7.0, 8.0, 9.0};
        Mean mean = new Mean();
        double ц = mean.evaluate(v);
        //System.out.println("ц:"+ String.format("%.2f", mean.evaluate(v)));
        System.out.println("ц:"+ц);

        StandardDeviation sd = new StandardDeviation();
        double σ = sd.evaluate(v);
        System.out.println("σ:"+ σ);
        //0.10278826788422096
        NormalDistribution nd = new NormalDistribution(0, 1);
        double i= 2.8;
        double z=(i-ц)/σ;
        System.out.println(i+"的正态分布是"+nd.cumulativeProbability(z));
        //System.err.println(1-0.9999260988448327);
        //System.out.println(0.5+nd.probability(-3, 3)/2);
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(50);
        Map<Integer,Double> map = new HashMap();
        map.put(20,0.2);
        map.put(30,0.3);
        map.put(50,0.5);

        double d = 0.2;
        double y = 0;

        for(Integer t : list){
            System.out.println((double)t / 100);
            //System.out.println(d <= t / 100);
            if(d <= (double)t/100){
                y = map.get(new Integer(t.intValue()));
            }
        }
        System.err.println("y"+y);

    }
}

