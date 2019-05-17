package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Knowledge;
import com.example.demo.bean.KnowledgeExample;
import com.example.demo.common.ReturnBean;
import com.example.demo.service.KnowledgeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/knowledge")
@Api("测试Knowledge")
public class KnowledgeController {

    private final static Logger logger = LoggerFactory.getLogger(KnowledgeController.class);

    @Autowired
    private KnowledgeService knowledgeService;


    @RequestMapping(value = "/selectKnowledgeById",method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取Knowledge")
    public Knowledge selectKnowledgeById(@RequestParam("id") Long id){
        logger.info("Knowledge is comeing" + id);
        Knowledge knowledge = knowledgeService.selectByPrimaryKey(id);
        logger.info(knowledge.toString());
        return knowledge;
    }

    @RequestMapping(value = "/pageKnowledge",method = RequestMethod.GET)
    @ApiOperation(value = "分页获取Knowledge信息")
    public Object pageKnowledge(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                       int pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                       int pageSize){
        logger.info("This is Page" + pageNum);
        KnowledgeExample knowledgeExample = null;

        return knowledgeService.findAllKnowledge(pageNum,pageSize,knowledgeExample);
    }

    @RequestMapping(value = "/addKnowledge",method = RequestMethod.POST)
    @ApiOperation(value = "添加Knowledge")
    public ReturnBean addKnowledge(@RequestBody Knowledge knowledge){
        ReturnBean returnBean = new ReturnBean();
        logger.info("Knowledge is add"+ JSONObject.toJSONString(knowledge));
        if(knowledgeService.insert(knowledge) > 0 ){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("添加成功");
            logger.info("添加成功");
        }else {
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("添加失败");
            logger.info("添加失败");
        }
        return returnBean;
    }


    @RequestMapping(value = "/deleteKnowledge",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除Knowledge")
    public ReturnBean deleteKnowledge(@RequestParam("id") Long id){
        ReturnBean returnBean = new ReturnBean();
        logger.info("Knowledge is delete");
        if(knowledgeService.deleteByPrimaryKey(id) > 0 ){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("删除成功");
            logger.info("删除成功");
        }else {
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("删除失败");
            logger.info("删除失败");
        }
        return returnBean;
    }

    //更新一条
    @RequestMapping(value ="updateKnowledge",method = RequestMethod.PUT)
    @ApiOperation(value = "更新一条数据")
    public ReturnBean updateKnowledge(@RequestBody Knowledge knowledge){
        ReturnBean returnBean = new ReturnBean();
        logger.info("Knowledge is update"+ JSONObject.toJSONString(knowledge));
        int count = knowledgeService.updateByPrimaryKey(knowledge);
        if(count > 0){
            returnBean.setReturnCode("1");
            returnBean.setReturnMessage("更新成功");
            logger.info("更新成功");
        }else{
            returnBean.setReturnCode("0");
            returnBean.setReturnMessage("更新失败");
            logger.info("更新失败");
        }
        return returnBean;
    }












}
