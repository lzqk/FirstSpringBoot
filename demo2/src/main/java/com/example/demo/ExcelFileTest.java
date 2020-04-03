package com.example.demo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LK
 * @Description:
 * @Date: Create in 17:10 2020/4/3
 */
public class ExcelFileTest {
    public static void main(String[] args) {
        //自定义标题别名
        /*Map<String,String> headerAlias = new LinkedHashMap<>();
        headerAlias.put("name", "姓名");
        headerAlias.put("age", "年龄");
        headerAlias.put("score", "分数");
        headerAlias.put("isPass", "是否通过");
        headerAlias.put("examDate", "考试时间");

        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("name", "张三");
        row1.put("age", 23);
        row1.put("score", 88.32);
        row1.put("isPass", true);
        row1.put("examDate", DateUtil.date());
        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("name", "李四");
        row2.put("age", 33);
        row2.put("score", 59.50);
        row2.put("isPass", false);
        row2.put("examDate", DateUtil.date());
        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);*/

        List<String> row1 = CollUtil.newArrayList("人员编号", "姓名", "工资", "绩效");
        List<List<String>> rows = new ArrayList<>();
        rows.add(row1);
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeBeanTest.xlsx");
        writer.getWorkbook().setSheetName(0, "量酬数据导入管理");
        //ExcelUtil.getWriter(true);

        //writer.setHeaderAlias(headerAlias);
        // 合并单元格后的标题行，使用默认标题样式
        //writer.merge(4, "一班成绩单");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows);
        // 关闭writer，释放内存
        writer.close();
    }
}
