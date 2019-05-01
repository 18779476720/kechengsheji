package com.example.kechengsheji.controller;


import com.example.kechengsheji.dao.dto.ApiResult;
import com.example.kechengsheji.service.ScoreinfoService;
import com.example.kechengsheji.model.Scoreinfo;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by chenglu on 2019-3-25.
 */
@Controller
@RequestMapping("/scoreinfo")
public class ScoreinfoController{

    @Autowired
    ScoreinfoService scoreinfoService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listScoreinfo(){
        Scoreinfo scoreinfo=new Scoreinfo();
        return scoreinfoService.list(scoreinfo);
    }

    @RequestMapping(value="/getByIdScoreinfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdScoreinfo(Integer id){
        return scoreinfoService.getById(id);
    }

    @RequestMapping(value="saveScore",method = RequestMethod.POST)
    @ResponseBody
    public Object insertScoreinfo(@RequestBody Scoreinfo scoreinfo){
        return scoreinfoService.insert(scoreinfo);
    }


    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateScoreinfo(@RequestBody Scoreinfo scoreinfo){
        return scoreinfoService.update(scoreinfo);
    }


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteScoreinfo(@RequestBody Scoreinfo scoreinfo){
        return scoreinfoService.delete(scoreinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteScoreinfoByIds(@RequestBody Integer[] ids){
        return scoreinfoService.deleteByIds(ids);
    }

    @RequestMapping(value="/getMyScoreinfo",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<?> getMyScoreinfo(@RequestParam("pageNum") Integer pageNum , @RequestParam("pageSize") Integer pageSize, HttpSession httpSession){
        Scoreinfo scoreinfo = new Scoreinfo();
        scoreinfo.setAccountId((Integer) httpSession.getAttribute("id"));
        return ApiResult.buildSuccess(scoreinfoService.getAll(scoreinfo,pageNum,pageSize));
    }

    //查询某条招聘信息的所有评价
    @RequestMapping(value="/getScoreByRecruit",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<?> getScoreByRecruit(@RequestParam("recruitId") Integer recruitId ,@RequestParam("pageNum") Integer pageNum , @RequestParam("pageSize") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Scoreinfo scoreinfo = new Scoreinfo();
        scoreinfo.setRecruitId(recruitId);
        List<Scoreinfo> list = scoreinfoService.list1(scoreinfo);
        PageInfo<Scoreinfo> pageInfo = new PageInfo<Scoreinfo>(list);
        return ApiResult.buildSuccess(pageInfo);
    }
}
