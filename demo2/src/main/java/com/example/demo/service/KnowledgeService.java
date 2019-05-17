package com.example.demo.service;

import com.example.demo.bean.Knowledge;
import com.example.demo.bean.KnowledgeExample;
import com.github.pagehelper.PageInfo;

public interface KnowledgeService {

    public Knowledge selectByPrimaryKey(Long id);

    public int deleteByPrimaryKey(Long id);

    public int insert(Knowledge record);

    public int updateByPrimaryKey(Knowledge record);

    public PageInfo<Knowledge> findAllKnowledge(int pageNum, int pageSize, KnowledgeExample knowledgeExample);
}
