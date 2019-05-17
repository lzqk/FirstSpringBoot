package com.example.demo.service.impl;


import com.example.demo.bean.Knowledge;
import com.example.demo.bean.KnowledgeExample;
import com.example.demo.mapper.KnowledgeMapper;
import com.example.demo.service.KnowledgeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("knowledgeService")
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Override
    public Knowledge selectByPrimaryKey(Long id){
        return knowledgeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return knowledgeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Knowledge record){
        return knowledgeMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Knowledge record){
        return knowledgeMapper.updateByPrimaryKey(record);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<Knowledge> findAllKnowledge(int pageNum, int pageSize, KnowledgeExample knowledgeExample) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Knowledge> knowledgeDomains = knowledgeMapper.selectByExample(knowledgeExample);
        PageInfo<Knowledge> result = new PageInfo<Knowledge>(knowledgeDomains);
        return result;
    }
}
