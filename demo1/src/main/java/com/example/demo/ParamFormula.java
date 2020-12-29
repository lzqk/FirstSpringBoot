package com.example.demo;



import org.apache.commons.jexl3.*;

import javax.el.Expression;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 前端传formula和params
 * 后端返回各数据源对象
 */
public class ParamFormula {

    /*public void jixiao() {
        String formula = "`区间函数`(`区间函数.绩效系数`,`量化薪酬指标.绩效`)";
        //区间函数：自定义函数
        //区间函数.绩效系数：单价表中的一条数据
        Map<String, String> params = new HashMap<>();
        params.put("`区间函数`", "{\"cnName\":\"区间函数\",\"enName\":\"paramFormula.interval\",\"type\":\"2\",\"source\":null}");
        params.put("`区间函数.绩效系数`", "{\"cnName\":\"绩效系数\",\"enName\":\"20200520002\",\"type\":\"1\",\"source\":\"3\"}");
        params.put("`量化薪酬指标.绩效`", "{\"cnName\":\"绩效\",\"enName\":\"20200520001\",\"type\":\"1\",\"source\":\"1\"}");
//        String[] eleKeys = {"`区间函数`", "`绩效系数`", "`绩效`"};
        calc(formula,params);
    }


    public void price() {
        String formula = "if(10<2){return `区间函数`(`区间函数.单价`,`量化薪酬指标.工单办结量`);}else{return 9;}";
        Map<String, String> params = new HashMap<>();

        //类型,1,其他表,2,自定义函数,3,公共函数
        //数据源,1,量化薪酬指标,2,员工信息,3,单价
        params.put("`区间函数`", "{\"cnName\":\"区间函数\",\"enName\":\"paramFormula.interval\",\"type\":\"2\",\"source\":\"\"}");
        params.put("`区间函数.单价`", "{\"cnName\":\"单价\",\"enName\":\"20200520002\",\"type\":\"1\",\"source\":\"3\"}");
        params.put("`量化薪酬指标.工单办结量`", "{\"cnName\":\"工单办结量\",\"enName\":\"20200520001\",\"type\":\"1\",\"source\":\"1\"}");
        calc(formula, params);
    }

    public void hujiaoliang(){
        String formula = "`量化薪酬指标.工单办结量`*`量化薪酬指标.工单阶梯单价`*`量化薪酬指标.绩效系数`";
        Map<String, String> params = new HashMap<>();

        //类型,1,其他表,2,自定义函数,3,公共函数
        //数据源,1,量化薪酬指标,2,员工信息,3,单价
        params.put("`量化薪酬指标.工单办结量`", "{\"cnName\":\"工单办结量\",\"enName\":\"20200520003\",\"type\":\"1\",\"source\":\"1\"}");
        params.put("`量化薪酬指标.工单阶梯单价`", "{\"cnName\":\"工单阶梯单价\",\"enName\":\"20200520002\",\"type\":\"1\",\"source\":\"1\"}");
        params.put("`量化薪酬指标.绩效系数`", "{\"cnName\":\"绩效系数\",\"enName\":\"20200520001\",\"type\":\"1\",\"source\":\"1\"}");
        calc(formula, params);
    }*/

    /*private void calc(String formula, Map<String, String> params) {
        formula = parseFormula(formula, params);
        Expression e = new JexlEngine().createExpression(formula);
        JexlContext jc = new MapContext();
        jc.set("paramFormula", ParamFormula.class);

        Object o = e.evaluate(jc);
        System.out.println("最终结果:" + o);
    }*/
    /*private void calc(String formula) {
        JexlEngine engine = new JexlEngine();//创建表达式引擎对象
        JexlContext context = new MapContext();//创建Context设值对象
        Expression e = new JexlEngine().createExpression(formula);
        JexlContext jc = new MapContext();
        jc.set("paramFormula", ParamFormula.class);
        jc.set("Math", Math.class);
        jc.set("BigDecimal", BigDecimal.class);
        Object o = e.evaluate(jc);
        System.out.println("最终结果:" + o);
    }*/

    /*private String parseFormula(String formula, Map<String, String> params) {
        for (String k : params.keySet()) {
            Formula operate = (Formula) JsonUtil.convertJson2Object(params.get(k), Formula.class);
            switch (operate.getType()) {
                case "1":
                    if (null == operate.getSource() || operate.getSource().equals("")) {
                        formula = formula.replace(k, operate.getEnName());
                    } else if (operate.getSource().equals("1")) {
                        formula = formula.replace(k, getProjValue(Long.valueOf(operate.getEnName())).toString());
                    } else if (operate.getSource().equals("2")) {
                        formula = formula.replace(k, getEmpInfo(operate.getEnName()).toString());
                    } else if (operate.getSource().equals("3")) {
                        formula = formula.replace(k, operate.getEnName());
                    }
                    break;
                case "2":
                    formula = formula.replace(k, operate.getEnName());
                    break;
                case "3":
                    formula = formula.replace(k, operate.getEnName());
                    break;
                default:
                    break;
            }
        }
        System.out.println(formula);
        return formula;
    }*/

    /**
     * 区间函数
     * @param itvId
     * @param projId
     * @return
     */
    public static Object interval(long itvId, long projId) {
        //取指标的值
        Object v = getProjValue(projId);
        System.out.println(v);
        //根据指标的值和单价表id从单价表取单价或绩效系数
        return 10;
    }

    //读取指标的值
    public static Object getProjValue(long projId) {
        //从量化薪酬计算表读取指标的值
        return 2;
    }

    //读员工信息
    public static Object getEmpInfo(String attr) {
        //从映射表和员工表读员工信息
        return "";
    }

    public static void main(String[] args) {
        JexlEngine engine = new JexlBuilder().create();//创建表达式引擎对象
        String ss = "if(10<2){return -1;}else if(10 =2){return 0;}else{return 1;}";

        JexlContext jc = new MapContext();
        //jc.set("a",new BigDecimal("100.0000000000"));
        //jc.set("b",new BigDecimal("200.0000000000"));
        //jc.set("paramFormula", ParamFormula.class);
        jc.set("Math", Math.class);
        jc.set("BigDecimal", BigDecimal.class);
        JexlExpression create = engine.createExpression(ss);
        Object o = create.evaluate(jc);
        System.out.println("最终结果:" + o);
        /*double c= 1196.52055425;
        double d= 1290.3316800000002;
        System.out.println(c+d);
        System.out.println(c);
        System.out.println(d);*/


    }

}
